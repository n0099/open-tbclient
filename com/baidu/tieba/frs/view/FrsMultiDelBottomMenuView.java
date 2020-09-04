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
    private View iey;
    private TextView ikB;
    private final com.baidu.tieba.NEGFeedBack.d izb;
    private TextView izc;
    private TextView izd;
    private View ize;
    private com.baidu.tieba.NEGFeedBack.e izf;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.izb = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.ikB = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.ikB.setText(R.string.cancel);
        this.izc = (TextView) findViewById(R.id.multi_del_btn);
        this.izc.setText(R.string.delete);
        this.izd = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.izd.setText(R.string.delete_and_forbidden_one_day);
        this.iey = findViewById(R.id.divider_top_line);
        this.ize = findViewById(R.id.divider);
        this.ikB.setOnClickListener(this);
        this.izc.setOnClickListener(this);
        this.izd.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.izc.setText(string);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.ikB, R.color.cp_cont_b);
        ap.setBackgroundResource(this.ikB, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.izd, R.color.cp_cont_b);
        ap.setBackgroundResource(this.izd, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.izc, R.color.cp_cont_h);
        ap.setBackgroundResource(this.izc, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.iey, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.ize, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.izb.registerListener();
        if (view == this.ikB) {
            com.baidu.tieba.frs.b.ckT().reset();
        } else if (view == this.izc) {
            if (!y.isEmpty(com.baidu.tieba.frs.b.ckT().ckQ())) {
                TiebaStatic.log(new aq("c13122").ai("obj_type", 1));
                setData(1);
                Jd("2");
            }
        } else if (view == this.izd && !y.isEmpty(com.baidu.tieba.frs.b.ckT().ckQ())) {
            TiebaStatic.log(new aq("c13122").ai("obj_type", 2));
            setData(2);
            Jd("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void Jd(String str) {
        if (this.pageContext != null) {
            if (this.izf == null) {
                this.izf = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.izf.Df(str);
        }
    }

    public void cnC() {
        if (this.izf != null) {
            this.izf.bAm();
        }
    }

    public void bAj() {
        if (this.izf != null) {
            this.izf.bAj();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.izf == null) {
                this.izf = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData ckU = com.baidu.tieba.frs.b.ckT().ckU();
            if (ckU != null && ckU.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ckU.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bw> ckQ = com.baidu.tieba.frs.b.ckT().ckQ();
            for (int i3 = 0; i3 < ckQ.size(); i3++) {
                jSONArray.put(ckQ.get(i3).getTid());
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            arVar.mT(i);
            arVar.P(jSONArray);
            arVar.setFid(com.baidu.tieba.frs.b.ckT().getForumId());
            this.izf.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.izf.setData(arVar);
        }
    }

    public void onDestroy() {
        if (this.izb != null) {
            this.izb.a((d.a) null);
            this.izb.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.izb != null) {
            this.izb.a(aVar);
        }
    }
}
