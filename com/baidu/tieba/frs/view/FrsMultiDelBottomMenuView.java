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
/* loaded from: classes9.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private TextView gCS;
    private final com.baidu.tieba.NEGFeedBack.d gQf;
    private TextView gQg;
    private TextView gQh;
    private View gQi;
    private com.baidu.tieba.NEGFeedBack.e gQj;
    private View gxM;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.gQf = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.gCS = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.gCS.setText(R.string.cancel);
        this.gQg = (TextView) findViewById(R.id.multi_del_btn);
        this.gQg.setText(R.string.delete);
        this.gQh = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.gQh.setText(R.string.delete_and_forbidden_one_day);
        this.gxM = findViewById(R.id.divider_top_line);
        this.gQi = findViewById(R.id.divider);
        this.gCS.setOnClickListener(this);
        this.gQg.setOnClickListener(this);
        this.gQh.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.gQg.setText(string);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this.gCS, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.gCS, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.gQh, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.gQh, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.gQg, (int) R.color.cp_cont_h);
        am.setBackgroundResource(this.gQg, R.drawable.bg_bottom_up_list_dialog_item);
        am.setBackgroundColor(this.gxM, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gQi, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.gQf.registerListener();
        if (view == this.gCS) {
            com.baidu.tieba.frs.a.bCV().reset();
        } else if (view == this.gQg) {
            if (!v.isEmpty(com.baidu.tieba.frs.a.bCV().bCX())) {
                TiebaStatic.log(new an("c13122").X("obj_type", 1));
                setData(1);
                BS("2");
            }
        } else if (view == this.gQh && !v.isEmpty(com.baidu.tieba.frs.a.bCV().bCX())) {
            TiebaStatic.log(new an("c13122").X("obj_type", 2));
            setData(2);
            BS("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void BS(String str) {
        if (this.pageContext != null) {
            if (this.gQj == null) {
                this.gQj = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.gQj.wm(str);
        }
    }

    public void bFn() {
        if (this.gQj != null) {
            this.gQj.aWq();
        }
    }

    public void aWn() {
        if (this.gQj != null) {
            this.gQj.aWn();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.gQj == null) {
                this.gQj = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData bCY = com.baidu.tieba.frs.a.bCV().bCY();
            if (bCY != null && bCY.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bCY.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bj> bCX = com.baidu.tieba.frs.a.bCV().bCX();
            for (int i3 = 0; i3 < bCX.size(); i3++) {
                jSONArray.put(bCX.get(i3).getTid());
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            alVar.jy(i);
            alVar.M(jSONArray);
            alVar.setFid(com.baidu.tieba.frs.a.bCV().getForumId());
            this.gQj.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.gQj.setData(alVar);
        }
    }

    public void onDestroy() {
        if (this.gQf != null) {
            this.gQf.a((d.a) null);
            this.gQf.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.gQf != null) {
            this.gQf.a(aVar);
        }
    }
}
