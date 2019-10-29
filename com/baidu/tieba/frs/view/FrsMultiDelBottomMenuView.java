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
    private View fEY;
    private TextView fKi;
    private final com.baidu.tieba.NEGFeedBack.d fXj;
    private TextView fXk;
    private TextView fXl;
    private View fXm;
    private com.baidu.tieba.NEGFeedBack.e fXn;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.fXj = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.fKi = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.fKi.setText(R.string.cancel);
        this.fXk = (TextView) findViewById(R.id.multi_del_btn);
        this.fXk.setText(R.string.delete);
        this.fXl = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.fXl.setText(R.string.delete_and_forbidden_one_day);
        this.fEY = findViewById(R.id.divider_top_line);
        this.fXm = findViewById(R.id.divider);
        this.fKi.setOnClickListener(this);
        this.fXk.setOnClickListener(this);
        this.fXl.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.fXk.setText(string);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this.fKi, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.fKi, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.fXl, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.fXl, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.fXk, (int) R.color.cp_cont_h);
        am.setBackgroundResource(this.fXk, R.drawable.bg_bottom_up_list_dialog_item);
        am.setBackgroundColor(this.fEY, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fXm, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fXj.registerListener();
        if (view == this.fKi) {
            com.baidu.tieba.frs.a.biW().reset();
        } else if (view == this.fXk) {
            if (!v.isEmpty(com.baidu.tieba.frs.a.biW().biY())) {
                TiebaStatic.log(new an("c13122").O("obj_type", 1));
                setData(1);
                wD("2");
            }
        } else if (view == this.fXl && !v.isEmpty(com.baidu.tieba.frs.a.biW().biY())) {
            TiebaStatic.log(new an("c13122").O("obj_type", 2));
            setData(2);
            wD("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void wD(String str) {
        if (this.pageContext != null) {
            if (this.fXn == null) {
                this.fXn = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.fXn.qE(str);
        }
    }

    public void bll() {
        if (this.fXn != null) {
            this.fXn.aBS();
        }
    }

    public void aBO() {
        if (this.fXn != null) {
            this.fXn.aBO();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.fXn == null) {
                this.fXn = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData biZ = com.baidu.tieba.frs.a.biW().biZ();
            if (biZ != null && biZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = biZ.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bh> biY = com.baidu.tieba.frs.a.biW().biY();
            for (int i3 = 0; i3 < biY.size(); i3++) {
                jSONArray.put(biY.get(i3).getTid());
            }
            aj ajVar = new aj();
            ajVar.setFeedBackReasonMap(sparseArray);
            ajVar.hw(i);
            ajVar.F(jSONArray);
            ajVar.setFid(com.baidu.tieba.frs.a.biW().getForumId());
            this.fXn.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.fXn.setData(ajVar);
        }
    }

    public void onDestroy() {
        if (this.fXj != null) {
            this.fXj.a((d.a) null);
            this.fXj.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.fXj != null) {
            this.fXj.a(aVar);
        }
    }
}
