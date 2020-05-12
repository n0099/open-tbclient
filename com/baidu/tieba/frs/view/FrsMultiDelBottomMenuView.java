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
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes9.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private final com.baidu.tieba.NEGFeedBack.d hBG;
    private TextView hBH;
    private TextView hBI;
    private View hBJ;
    private e hBK;
    private View hil;
    private TextView hnE;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.hBG = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.hnE = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.hnE.setText(R.string.cancel);
        this.hBH = (TextView) findViewById(R.id.multi_del_btn);
        this.hBH.setText(R.string.delete);
        this.hBI = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.hBI.setText(R.string.delete_and_forbidden_one_day);
        this.hil = findViewById(R.id.divider_top_line);
        this.hBJ = findViewById(R.id.divider);
        this.hnE.setOnClickListener(this);
        this.hBH.setOnClickListener(this);
        this.hBI.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.hBH.setText(string);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this.hnE, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.hnE, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.hBI, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.hBI, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.hBH, (int) R.color.cp_cont_h);
        am.setBackgroundResource(this.hBH, R.drawable.bg_bottom_up_list_dialog_item);
        am.setBackgroundColor(this.hil, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.hBJ, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.hBG.registerListener();
        if (view == this.hnE) {
            com.baidu.tieba.frs.a.bNC().reset();
        } else if (view == this.hBH) {
            if (!v.isEmpty(com.baidu.tieba.frs.a.bNC().bNE())) {
                TiebaStatic.log(new an("c13122").af("obj_type", 1));
                setData(1);
                DE("2");
            }
        } else if (view == this.hBI && !v.isEmpty(com.baidu.tieba.frs.a.bNC().bNE())) {
            TiebaStatic.log(new an("c13122").af("obj_type", 2));
            setData(2);
            DE("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void DE(String str) {
        if (this.pageContext != null) {
            if (this.hBK == null) {
                this.hBK = new e(this.pageContext, this);
            }
            this.hBK.xD(str);
        }
    }

    public void bPY() {
        if (this.hBK != null) {
            this.hBK.beE();
        }
    }

    public void beB() {
        if (this.hBK != null) {
            this.hBK.beB();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.hBK == null) {
                this.hBK = new e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData bNF = com.baidu.tieba.frs.a.bNC().bNF();
            if (bNF != null && bNF.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bNF.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bj> bNE = com.baidu.tieba.frs.a.bNC().bNE();
            for (int i3 = 0; i3 < bNE.size(); i3++) {
                jSONArray.put(bNE.get(i3).getTid());
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            alVar.jF(i);
            alVar.N(jSONArray);
            alVar.setFid(com.baidu.tieba.frs.a.bNC().getForumId());
            this.hBK.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.hBK.setData(alVar);
        }
    }

    public void onDestroy() {
        if (this.hBG != null) {
            this.hBG.a((d.a) null);
            this.hBG.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.hBG != null) {
            this.hBG.a(aVar);
        }
    }
}
