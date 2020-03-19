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
    private TextView gEc;
    private TextView gRA;
    private View gRB;
    private com.baidu.tieba.NEGFeedBack.e gRC;
    private final com.baidu.tieba.NEGFeedBack.d gRy;
    private TextView gRz;
    private View gyJ;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.gRy = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.gEc = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.gEc.setText(R.string.cancel);
        this.gRz = (TextView) findViewById(R.id.multi_del_btn);
        this.gRz.setText(R.string.delete);
        this.gRA = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.gRA.setText(R.string.delete_and_forbidden_one_day);
        this.gyJ = findViewById(R.id.divider_top_line);
        this.gRB = findViewById(R.id.divider);
        this.gEc.setOnClickListener(this);
        this.gRz.setOnClickListener(this);
        this.gRA.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.gRz.setText(string);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this.gEc, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.gEc, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.gRA, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.gRA, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.gRz, (int) R.color.cp_cont_h);
        am.setBackgroundResource(this.gRz, R.drawable.bg_bottom_up_list_dialog_item);
        am.setBackgroundColor(this.gyJ, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gRB, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.gRy.registerListener();
        if (view == this.gEc) {
            com.baidu.tieba.frs.a.bDd().reset();
        } else if (view == this.gRz) {
            if (!v.isEmpty(com.baidu.tieba.frs.a.bDd().bDf())) {
                TiebaStatic.log(new an("c13122").X("obj_type", 1));
                setData(1);
                BT("2");
            }
        } else if (view == this.gRA && !v.isEmpty(com.baidu.tieba.frs.a.bDd().bDf())) {
            TiebaStatic.log(new an("c13122").X("obj_type", 2));
            setData(2);
            BT("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void BT(String str) {
        if (this.pageContext != null) {
            if (this.gRC == null) {
                this.gRC = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.gRC.wo(str);
        }
    }

    public void bFy() {
        if (this.gRC != null) {
            this.gRC.aWv();
        }
    }

    public void aWs() {
        if (this.gRC != null) {
            this.gRC.aWs();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.gRC == null) {
                this.gRC = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData bDg = com.baidu.tieba.frs.a.bDd().bDg();
            if (bDg != null && bDg.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bDg.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bj> bDf = com.baidu.tieba.frs.a.bDd().bDf();
            for (int i3 = 0; i3 < bDf.size(); i3++) {
                jSONArray.put(bDf.get(i3).getTid());
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            alVar.jy(i);
            alVar.M(jSONArray);
            alVar.setFid(com.baidu.tieba.frs.a.bDd().getForumId());
            this.gRC.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.gRC.setData(alVar);
        }
    }

    public void onDestroy() {
        if (this.gRy != null) {
            this.gRy.a((d.a) null);
            this.gRy.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.gRy != null) {
            this.gRy.a(aVar);
        }
    }
}
