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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.NEGFeedBack.d;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes16.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View hQj;
    private TextView hWo;
    private final com.baidu.tieba.NEGFeedBack.d ikS;
    private TextView ikT;
    private TextView ikU;
    private View ikV;
    private com.baidu.tieba.NEGFeedBack.e ikW;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.ikS = new com.baidu.tieba.NEGFeedBack.d("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.hWo = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.hWo.setText(R.string.cancel);
        this.ikT = (TextView) findViewById(R.id.multi_del_btn);
        this.ikT.setText(R.string.delete);
        this.ikU = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.ikU.setText(R.string.delete_and_forbidden_one_day);
        this.hQj = findViewById(R.id.divider_top_line);
        this.ikV = findViewById(R.id.divider);
        this.hWo.setOnClickListener(this);
        this.ikT.setOnClickListener(this);
        this.ikU.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.ikT.setText(string);
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.hWo, R.color.cp_cont_b);
        ao.setBackgroundResource(this.hWo, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.ikU, R.color.cp_cont_b);
        ao.setBackgroundResource(this.ikU, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setViewTextColor(this.ikT, R.color.cp_cont_h);
        ao.setBackgroundResource(this.ikT, R.drawable.bg_bottom_up_list_dialog_item);
        ao.setBackgroundColor(this.hQj, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.ikV, R.color.cp_bg_line_c);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ikS.registerListener();
        if (view == this.hWo) {
            com.baidu.tieba.frs.b.caw().reset();
        } else if (view == this.ikT) {
            if (!x.isEmpty(com.baidu.tieba.frs.b.caw().cat())) {
                TiebaStatic.log(new ap("c13122").ah("obj_type", 1));
                setData(1);
                GA("2");
            }
        } else if (view == this.ikU && !x.isEmpty(com.baidu.tieba.frs.b.caw().cat())) {
            TiebaStatic.log(new ap("c13122").ah("obj_type", 2));
            setData(2);
            GA("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void GA(String str) {
        if (this.pageContext != null) {
            if (this.ikW == null) {
                this.ikW = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            this.ikW.AK(str);
        }
    }

    public void cde() {
        if (this.ikW != null) {
            this.ikW.bro();
        }
    }

    public void brl() {
        if (this.ikW != null) {
            this.ikW.brl();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.ikW == null) {
                this.ikW = new com.baidu.tieba.NEGFeedBack.e(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData cax = com.baidu.tieba.frs.b.caw().cax();
            if (cax != null && cax.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cax.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<bv> cat = com.baidu.tieba.frs.b.caw().cat();
            for (int i3 = 0; i3 < cat.size(); i3++) {
                jSONArray.put(cat.get(i3).getTid());
            }
            aq aqVar = new aq();
            aqVar.setFeedBackReasonMap(sparseArray);
            aqVar.kN(i);
            aqVar.N(jSONArray);
            aqVar.setFid(com.baidu.tieba.frs.b.caw().getForumId());
            this.ikW.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.ikW.setData(aqVar);
        }
    }

    public void onDestroy() {
        if (this.ikS != null) {
            this.ikS.a((d.a) null);
            this.ikS.onDestroy();
        }
    }

    public void setDeleteCallback(d.a aVar) {
        if (this.ikS != null) {
            this.ikS.a(aVar);
        }
    }
}
