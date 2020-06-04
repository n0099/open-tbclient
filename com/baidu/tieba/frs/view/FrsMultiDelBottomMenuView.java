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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes9.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private TextView hDf;
    private final com.baidu.tieba.NEGFeedBack.d hRg;
    private TextView hRh;
    private TextView hRi;
    private View hRj;
    private e hRk;
    private View hxj;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.hRg = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.hDf = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.hDf.setText(R.string.cancel);
        this.hRh = (TextView) findViewById(R.id.multi_del_btn);
        this.hRh.setText(R.string.delete);
        this.hRi = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.hRi.setText(R.string.delete_and_forbidden_one_day);
        this.hxj = findViewById(R.id.divider_top_line);
        this.hRj = findViewById(R.id.divider);
        this.hDf.setOnClickListener(this);
        this.hRh.setOnClickListener(this);
        this.hRi.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.hRh.setText(string);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this.hDf, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.hDf, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.hRi, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.hRi, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.hRh, (int) R.color.cp_cont_h);
        am.setBackgroundResource(this.hRh, R.drawable.bg_bottom_up_list_dialog_item);
        am.setBackgroundColor(this.hxj, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.hRj, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.hRg.registerListener();
        if (view == this.hDf) {
            com.baidu.tieba.frs.a.bTZ().reset();
        } else if (view == this.hRh) {
            if (!v.isEmpty(com.baidu.tieba.frs.a.bTZ().bUb())) {
                TiebaStatic.log(new an("c13122").ag("obj_type", 1));
                setData(1);
                Fn("2");
            }
        } else if (view == this.hRi && !v.isEmpty(com.baidu.tieba.frs.a.bTZ().bUb())) {
            TiebaStatic.log(new an("c13122").ag("obj_type", 2));
            setData(2);
            Fn("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void Fn(String str) {
        if (this.pageContext != null) {
            if (this.hRk == null) {
                this.hRk = new e(this.pageContext, this);
            }
            this.hRk.zj(str);
        }
    }

    public void bWw() {
        if (this.hRk != null) {
            this.hRk.bkT();
        }
    }

    public void bkQ() {
        if (this.hRk != null) {
            this.hRk.bkQ();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.hRk == null) {
                this.hRk = new e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData bUc = com.baidu.tieba.frs.a.bTZ().bUc();
            if (bUc != null && bUc.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bUc.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bk> bUb = com.baidu.tieba.frs.a.bTZ().bUb();
            for (int i3 = 0; i3 < bUb.size(); i3++) {
                jSONArray.put(bUb.get(i3).getTid());
            }
            ak akVar = new ak();
            akVar.setFeedBackReasonMap(sparseArray);
            akVar.kh(i);
            akVar.M(jSONArray);
            akVar.setFid(com.baidu.tieba.frs.a.bTZ().getForumId());
            this.hRk.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.hRk.setData(akVar);
        }
    }

    public void onDestroy() {
        if (this.hRg != null) {
            this.hRg.a((d.a) null);
            this.hRg.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.hRg != null) {
            this.hRg.a(aVar);
        }
    }
}
