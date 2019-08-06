package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes4.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View fDU;
    private TextView fIZ;
    private final com.baidu.tieba.NEGFeedBack.d fVX;
    private TextView fVY;
    private TextView fVZ;
    private View fWa;
    private com.baidu.tieba.NEGFeedBack.e fWb;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.fVX = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.fIZ = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.fIZ.setText(R.string.cancel);
        this.fVY = (TextView) findViewById(R.id.multi_del_btn);
        this.fVY.setText(R.string.delete);
        this.fVZ = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.fVZ.setText(R.string.delete_and_forbidden_one_day);
        this.fDU = findViewById(R.id.divider_top_line);
        this.fWa = findViewById(R.id.divider);
        this.fIZ.setOnClickListener(this);
        this.fVY.setOnClickListener(this);
        this.fVZ.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.fVY.setText(string);
    }

    public void onChangeSkinType() {
        am.l(this, R.color.cp_bg_line_d);
        am.j(this.fIZ, R.color.cp_cont_b);
        am.k(this.fIZ, R.drawable.bg_bottom_up_list_dialog_item);
        am.j(this.fVZ, R.color.cp_cont_b);
        am.k(this.fVZ, R.drawable.bg_bottom_up_list_dialog_item);
        am.j(this.fVY, R.color.cp_cont_h);
        am.k(this.fVY, R.drawable.bg_bottom_up_list_dialog_item);
        am.l(this.fDU, R.color.cp_bg_line_c);
        am.l(this.fWa, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fVX.registerListener();
        if (view == this.fIZ) {
            com.baidu.tieba.frs.a.blf().reset();
        } else if (view == this.fVY) {
            if (!v.aa(com.baidu.tieba.frs.a.blf().blh())) {
                TiebaStatic.log(new an("c13122").P("obj_type", 1));
                setData(1);
                xM("2");
            }
        } else if (view == this.fVZ && !v.aa(com.baidu.tieba.frs.a.blf().blh())) {
            TiebaStatic.log(new an("c13122").P("obj_type", 2));
            setData(2);
            xM("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void xM(String str) {
        if (this.pageContext != null) {
            if (this.fWb == null) {
                this.fWb = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.fWb.rJ(str);
        }
    }

    public void bnv() {
        if (this.fWb != null) {
            this.fWb.aBu();
        }
    }

    public void aBp() {
        if (this.fWb != null) {
            this.fWb.aBp();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.fWb == null) {
                this.fWb = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData bli = com.baidu.tieba.frs.a.blf().bli();
            if (bli != null && bli.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bli.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bh> blh = com.baidu.tieba.frs.a.blf().blh();
            for (int i3 = 0; i3 < blh.size(); i3++) {
                jSONArray.put(blh.get(i3).getTid());
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray);
            ajVar.gW(i);
            ajVar.x(jSONArray);
            ajVar.setFid(com.baidu.tieba.frs.a.blf().getForumId());
            this.fWb.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.fWb.setData(ajVar);
        }
    }

    public void onDestroy() {
        if (this.fVX != null) {
            this.fVX.a((d.a) null);
            this.fVX.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.fVX != null) {
            this.fVX.a(aVar);
        }
    }
}
