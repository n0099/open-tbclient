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
/* loaded from: classes21.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private com.baidu.tieba.NEGFeedBack.e iGA;
    private final com.baidu.tieba.NEGFeedBack.d iGw;
    private TextView iGx;
    private TextView iGy;
    private View iGz;
    private View ily;
    private TextView irD;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.iGw = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.irD = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.irD.setText(R.string.cancel);
        this.iGx = (TextView) findViewById(R.id.multi_del_btn);
        this.iGx.setText(R.string.delete);
        this.iGy = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.iGy.setText(R.string.delete_and_forbidden_one_day);
        this.ily = findViewById(R.id.divider_top_line);
        this.iGz = findViewById(R.id.divider);
        this.irD.setOnClickListener(this);
        this.iGx.setOnClickListener(this);
        this.iGy.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.iGx.setText(string);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.irD, R.color.cp_cont_b);
        ap.setBackgroundResource(this.irD, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.iGy, R.color.cp_cont_b);
        ap.setBackgroundResource(this.iGy, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.iGx, R.color.cp_cont_h);
        ap.setBackgroundResource(this.iGx, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.ily, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.iGz, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.iGw.registerListener();
        if (view == this.irD) {
            com.baidu.tieba.frs.b.cog().reset();
        } else if (view == this.iGx) {
            if (!y.isEmpty(com.baidu.tieba.frs.b.cog().cod())) {
                TiebaStatic.log(new aq("c13122").ai("obj_type", 1));
                setData(1);
                JB("2");
            }
        } else if (view == this.iGy && !y.isEmpty(com.baidu.tieba.frs.b.cog().cod())) {
            TiebaStatic.log(new aq("c13122").ai("obj_type", 2));
            setData(2);
            JB("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void JB(String str) {
        if (this.pageContext != null) {
            if (this.iGA == null) {
                this.iGA = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.iGA.DC(str);
        }
    }

    public void cqO() {
        if (this.iGA != null) {
            this.iGA.bBv();
        }
    }

    public void bBs() {
        if (this.iGA != null) {
            this.iGA.bBs();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.iGA == null) {
                this.iGA = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData coh = com.baidu.tieba.frs.b.cog().coh();
            if (coh != null && coh.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = coh.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bw> cod = com.baidu.tieba.frs.b.cog().cod();
            for (int i3 = 0; i3 < cod.size(); i3++) {
                jSONArray.put(cod.get(i3).getTid());
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            arVar.ne(i);
            arVar.P(jSONArray);
            arVar.setFid(com.baidu.tieba.frs.b.cog().getForumId());
            this.iGA.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.iGA.setData(arVar);
        }
    }

    public void onDestroy() {
        if (this.iGw != null) {
            this.iGw.a((d.a) null);
            this.iGw.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.iGw != null) {
            this.iGw.a(aVar);
        }
    }
}
