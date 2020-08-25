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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes16.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View ies;
    private TextView ikv;
    private final com.baidu.tieba.NEGFeedBack.d iyV;
    private TextView iyW;
    private TextView iyX;
    private View iyY;
    private com.baidu.tieba.NEGFeedBack.e iyZ;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.iyV = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.ikv = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.ikv.setText(R.string.cancel);
        this.iyW = (TextView) findViewById(R.id.multi_del_btn);
        this.iyW.setText(R.string.delete);
        this.iyX = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.iyX.setText(R.string.delete_and_forbidden_one_day);
        this.ies = findViewById(R.id.divider_top_line);
        this.iyY = findViewById(R.id.divider);
        this.ikv.setOnClickListener(this);
        this.iyW.setOnClickListener(this);
        this.iyX.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.iyW.setText(string);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.ikv, R.color.cp_cont_b);
        ap.setBackgroundResource(this.ikv, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.iyX, R.color.cp_cont_b);
        ap.setBackgroundResource(this.iyX, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.iyW, R.color.cp_cont_h);
        ap.setBackgroundResource(this.iyW, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.ies, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.iyY, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.iyV.registerListener();
        if (view == this.ikv) {
            com.baidu.tieba.frs.b.ckS().reset();
        } else if (view == this.iyW) {
            if (!y.isEmpty(com.baidu.tieba.frs.b.ckS().ckP())) {
                TiebaStatic.log(new aq("c13122").ai("obj_type", 1));
                setData(1);
                Jc("2");
            }
        } else if (view == this.iyX && !y.isEmpty(com.baidu.tieba.frs.b.ckS().ckP())) {
            TiebaStatic.log(new aq("c13122").ai("obj_type", 2));
            setData(2);
            Jc("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void Jc(String str) {
        if (this.pageContext != null) {
            if (this.iyZ == null) {
                this.iyZ = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.iyZ.De(str);
        }
    }

    public void cnB() {
        if (this.iyZ != null) {
            this.iyZ.bAl();
        }
    }

    public void bAi() {
        if (this.iyZ != null) {
            this.iyZ.bAi();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.iyZ == null) {
                this.iyZ = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData ckT = com.baidu.tieba.frs.b.ckS().ckT();
            if (ckT != null && ckT.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ckT.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bw> ckP = com.baidu.tieba.frs.b.ckS().ckP();
            for (int i3 = 0; i3 < ckP.size(); i3++) {
                jSONArray.put(ckP.get(i3).getTid());
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            arVar.mT(i);
            arVar.P(jSONArray);
            arVar.setFid(com.baidu.tieba.frs.b.ckS().getForumId());
            this.iyZ.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.iyZ.setData(arVar);
        }
    }

    public void onDestroy() {
        if (this.iyV != null) {
            this.iyV.a((d.a) null);
            this.iyV.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.iyV != null) {
            this.iyV.a(aVar);
        }
    }
}
