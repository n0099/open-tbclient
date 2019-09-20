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
    private View fFH;
    private TextView fKO;
    private final com.baidu.tieba.NEGFeedBack.d fXO;
    private TextView fXP;
    private TextView fXQ;
    private View fXR;
    private com.baidu.tieba.NEGFeedBack.e fXS;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.fXO = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.fKO = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.fKO.setText(R.string.cancel);
        this.fXP = (TextView) findViewById(R.id.multi_del_btn);
        this.fXP.setText(R.string.delete);
        this.fXQ = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.fXQ.setText(R.string.delete_and_forbidden_one_day);
        this.fFH = findViewById(R.id.divider_top_line);
        this.fXR = findViewById(R.id.divider);
        this.fKO.setOnClickListener(this);
        this.fXP.setOnClickListener(this);
        this.fXQ.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.fXP.setText(string);
    }

    public void onChangeSkinType() {
        am.l(this, R.color.cp_bg_line_d);
        am.j(this.fKO, R.color.cp_cont_b);
        am.k(this.fKO, R.drawable.bg_bottom_up_list_dialog_item);
        am.j(this.fXQ, R.color.cp_cont_b);
        am.k(this.fXQ, R.drawable.bg_bottom_up_list_dialog_item);
        am.j(this.fXP, R.color.cp_cont_h);
        am.k(this.fXP, R.drawable.bg_bottom_up_list_dialog_item);
        am.l(this.fFH, R.color.cp_bg_line_c);
        am.l(this.fXR, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fXO.registerListener();
        if (view == this.fKO) {
            com.baidu.tieba.frs.a.blQ().reset();
        } else if (view == this.fXP) {
            if (!v.aa(com.baidu.tieba.frs.a.blQ().blS())) {
                TiebaStatic.log(new an("c13122").P("obj_type", 1));
                setData(1);
                yl("2");
            }
        } else if (view == this.fXQ && !v.aa(com.baidu.tieba.frs.a.blQ().blS())) {
            TiebaStatic.log(new an("c13122").P("obj_type", 2));
            setData(2);
            yl("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void yl(String str) {
        if (this.pageContext != null) {
            if (this.fXS == null) {
                this.fXS = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.fXS.rU(str);
        }
    }

    public void bog() {
        if (this.fXS != null) {
            this.fXS.aBI();
        }
    }

    public void aBD() {
        if (this.fXS != null) {
            this.fXS.aBD();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.fXS == null) {
                this.fXS = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData blT = com.baidu.tieba.frs.a.blQ().blT();
            if (blT != null && blT.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = blT.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bh> blS = com.baidu.tieba.frs.a.blQ().blS();
            for (int i3 = 0; i3 < blS.size(); i3++) {
                jSONArray.put(blS.get(i3).getTid());
            }
            aj ajVar = new aj();
            ajVar.b(sparseArray);
            ajVar.gX(i);
            ajVar.x(jSONArray);
            ajVar.setFid(com.baidu.tieba.frs.a.blQ().getForumId());
            this.fXS.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.fXS.setData(ajVar);
        }
    }

    public void onDestroy() {
        if (this.fXO != null) {
            this.fXO.a((d.a) null);
            this.fXO.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.fXO != null) {
            this.fXO.a(aVar);
        }
    }
}
