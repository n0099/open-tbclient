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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
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
/* loaded from: classes6.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private final com.baidu.tieba.NEGFeedBack.d gKQ;
    private TextView gKR;
    private TextView gKS;
    private View gKT;
    private com.baidu.tieba.NEGFeedBack.e gKU;
    private View gsA;
    private TextView gxG;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.gKQ = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.gxG = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.gxG.setText(R.string.cancel);
        this.gKR = (TextView) findViewById(R.id.multi_del_btn);
        this.gKR.setText(R.string.delete);
        this.gKS = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.gKS.setText(R.string.delete_and_forbidden_one_day);
        this.gsA = findViewById(R.id.divider_top_line);
        this.gKT = findViewById(R.id.divider);
        this.gxG.setOnClickListener(this);
        this.gKR.setOnClickListener(this);
        this.gKS.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.gKR.setText(string);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this.gxG, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.gxG, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.gKS, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.gKS, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.gKR, (int) R.color.cp_cont_h);
        am.setBackgroundResource(this.gKR, R.drawable.bg_bottom_up_list_dialog_item);
        am.setBackgroundColor(this.gsA, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gKT, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.gKQ.registerListener();
        if (view == this.gxG) {
            com.baidu.tieba.frs.a.bAp().reset();
        } else if (view == this.gKR) {
            if (!v.isEmpty(com.baidu.tieba.frs.a.bAp().bAr())) {
                TiebaStatic.log(new an("c13122").Z("obj_type", 1));
                setData(1);
                Bs("2");
            }
        } else if (view == this.gKS && !v.isEmpty(com.baidu.tieba.frs.a.bAp().bAr())) {
            TiebaStatic.log(new an("c13122").Z("obj_type", 2));
            setData(2);
            Bs("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void Bs(String str) {
        if (this.pageContext != null) {
            if (this.gKU == null) {
                this.gKU = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.gKU.vO(str);
        }
    }

    public void bCG() {
        if (this.gKU != null) {
            this.gKU.aTE();
        }
    }

    public void aTB() {
        if (this.gKU != null) {
            this.gKU.aTB();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.gKU == null) {
                this.gKU = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData bAs = com.baidu.tieba.frs.a.bAp().bAs();
            if (bAs != null && bAs.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bAs.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bj> bAr = com.baidu.tieba.frs.a.bAp().bAr();
            for (int i3 = 0; i3 < bAr.size(); i3++) {
                jSONArray.put(bAr.get(i3).getTid());
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            alVar.jg(i);
            alVar.L(jSONArray);
            alVar.setFid(com.baidu.tieba.frs.a.bAp().getForumId());
            this.gKU.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.gKU.setData(alVar);
        }
    }

    public void onDestroy() {
        if (this.gKQ != null) {
            this.gKQ.a((d.a) null);
            this.gKQ.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.gKQ != null) {
            this.gKQ.a(aVar);
        }
    }
}
