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
    private TextView gCQ;
    private final com.baidu.tieba.NEGFeedBack.d gQd;
    private TextView gQe;
    private TextView gQf;
    private View gQg;
    private com.baidu.tieba.NEGFeedBack.e gQh;
    private View gxK;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.gQd = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.gCQ = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.gCQ.setText(R.string.cancel);
        this.gQe = (TextView) findViewById(R.id.multi_del_btn);
        this.gQe.setText(R.string.delete);
        this.gQf = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.gQf.setText(R.string.delete_and_forbidden_one_day);
        this.gxK = findViewById(R.id.divider_top_line);
        this.gQg = findViewById(R.id.divider);
        this.gCQ.setOnClickListener(this);
        this.gQe.setOnClickListener(this);
        this.gQf.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.gQe.setText(string);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this.gCQ, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.gCQ, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.gQf, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.gQf, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.gQe, (int) R.color.cp_cont_h);
        am.setBackgroundResource(this.gQe, R.drawable.bg_bottom_up_list_dialog_item);
        am.setBackgroundColor(this.gxK, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gQg, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.gQd.registerListener();
        if (view == this.gCQ) {
            com.baidu.tieba.frs.a.bCT().reset();
        } else if (view == this.gQe) {
            if (!v.isEmpty(com.baidu.tieba.frs.a.bCT().bCV())) {
                TiebaStatic.log(new an("c13122").X("obj_type", 1));
                setData(1);
                BS("2");
            }
        } else if (view == this.gQf && !v.isEmpty(com.baidu.tieba.frs.a.bCT().bCV())) {
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
            if (this.gQh == null) {
                this.gQh = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.gQh.wm(str);
        }
    }

    public void bFl() {
        if (this.gQh != null) {
            this.gQh.aWo();
        }
    }

    public void aWl() {
        if (this.gQh != null) {
            this.gQh.aWl();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.gQh == null) {
                this.gQh = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData bCW = com.baidu.tieba.frs.a.bCT().bCW();
            if (bCW != null && bCW.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bCW.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bj> bCV = com.baidu.tieba.frs.a.bCT().bCV();
            for (int i3 = 0; i3 < bCV.size(); i3++) {
                jSONArray.put(bCV.get(i3).getTid());
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            alVar.jy(i);
            alVar.M(jSONArray);
            alVar.setFid(com.baidu.tieba.frs.a.bCT().getForumId());
            this.gQh.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.gQh.setData(alVar);
        }
    }

    public void onDestroy() {
        if (this.gQd != null) {
            this.gQd.a((d.a) null);
            this.gQd.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.gQd != null) {
            this.gQd.a(aVar);
        }
    }
}
