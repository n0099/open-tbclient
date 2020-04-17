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
    private final com.baidu.tieba.NEGFeedBack.d hBA;
    private TextView hBB;
    private TextView hBC;
    private View hBD;
    private e hBE;
    private View hif;
    private TextView hny;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.hBA = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.hny = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.hny.setText(R.string.cancel);
        this.hBB = (TextView) findViewById(R.id.multi_del_btn);
        this.hBB.setText(R.string.delete);
        this.hBC = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.hBC.setText(R.string.delete_and_forbidden_one_day);
        this.hif = findViewById(R.id.divider_top_line);
        this.hBD = findViewById(R.id.divider);
        this.hny.setOnClickListener(this);
        this.hBB.setOnClickListener(this);
        this.hBC.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.hBB.setText(string);
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        am.setViewTextColor(this.hny, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.hny, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.hBC, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.hBC, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.hBB, (int) R.color.cp_cont_h);
        am.setBackgroundResource(this.hBB, R.drawable.bg_bottom_up_list_dialog_item);
        am.setBackgroundColor(this.hif, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.hBD, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.hBA.registerListener();
        if (view == this.hny) {
            com.baidu.tieba.frs.a.bND().reset();
        } else if (view == this.hBB) {
            if (!v.isEmpty(com.baidu.tieba.frs.a.bND().bNF())) {
                TiebaStatic.log(new an("c13122").af("obj_type", 1));
                setData(1);
                DB("2");
            }
        } else if (view == this.hBC && !v.isEmpty(com.baidu.tieba.frs.a.bND().bNF())) {
            TiebaStatic.log(new an("c13122").af("obj_type", 2));
            setData(2);
            DB("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void DB(String str) {
        if (this.pageContext != null) {
            if (this.hBE == null) {
                this.hBE = new e(this.pageContext, this);
            }
            this.hBE.xA(str);
        }
    }

    public void bPZ() {
        if (this.hBE != null) {
            this.hBE.beG();
        }
    }

    public void beD() {
        if (this.hBE != null) {
            this.hBE.beD();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.hBE == null) {
                this.hBE = new e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData bNG = com.baidu.tieba.frs.a.bND().bNG();
            if (bNG != null && bNG.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bNG.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bj> bNF = com.baidu.tieba.frs.a.bND().bNF();
            for (int i3 = 0; i3 < bNF.size(); i3++) {
                jSONArray.put(bNF.get(i3).getTid());
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            alVar.jF(i);
            alVar.N(jSONArray);
            alVar.setFid(com.baidu.tieba.frs.a.bND().getForumId());
            this.hBE.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.hBE.setData(alVar);
        }
    }

    public void onDestroy() {
        if (this.hBA != null) {
            this.hBA.a((d.a) null);
            this.hBA.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.hBA != null) {
            this.hBA.a(aVar);
        }
    }
}
