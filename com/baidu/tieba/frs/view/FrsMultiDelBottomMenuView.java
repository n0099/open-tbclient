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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.NEGFeedBack.f;
import com.baidu.tieba.R;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes2.dex */
public class FrsMultiDelBottomMenuView extends RelativeLayout implements View.OnClickListener {
    private View bQV;
    private TextView jAP;
    private final com.baidu.tieba.NEGFeedBack.e jRe;
    private TextView jRf;
    private TextView jRg;
    private View jRh;
    private f jRi;
    private TbPageContext pageContext;

    public FrsMultiDelBottomMenuView(Context context) {
        this(context, null);
    }

    public FrsMultiDelBottomMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
        this.jRe = new com.baidu.tieba.NEGFeedBack.e("0");
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.frs_multi_delete_menu_layout, this);
        this.jAP = (TextView) findViewById(R.id.multi_del_cancel_btn);
        this.jAP.setText(R.string.cancel);
        this.jRf = (TextView) findViewById(R.id.multi_del_btn);
        this.jRf.setText(R.string.delete);
        this.jRg = (TextView) findViewById(R.id.multi_del_forbidden_btn);
        this.jRg.setText(R.string.delete_and_forbidden_one_day);
        this.bQV = findViewById(R.id.divider_top_line);
        this.jRh = findViewById(R.id.divider);
        this.jAP.setOnClickListener(this);
        this.jRf.setOnClickListener(this);
        this.jRg.setOnClickListener(this);
        onChangeSkinType();
        setClickable(true);
    }

    public void setSelectNumber(int i) {
        String string = getContext().getString(R.string.delete);
        if (i > 0) {
            string = string + String.format(Locale.CHINA, "(%d)", Integer.valueOf(i));
        }
        this.jRf.setText(string);
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setViewTextColor(this.jAP, R.color.CAM_X0105);
        ap.setBackgroundResource(this.jAP, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jRg, R.color.CAM_X0105);
        ap.setBackgroundResource(this.jRg, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.jRf, R.color.CAM_X0301);
        ap.setBackgroundResource(this.jRf, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setBackgroundColor(this.bQV, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jRh, R.color.CAM_X0204);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.jRe.registerListener();
        if (view == this.jAP) {
            com.baidu.tieba.frs.b.cBy().reset();
        } else if (view == this.jRf) {
            if (!y.isEmpty(com.baidu.tieba.frs.b.cBy().cBv())) {
                TiebaStatic.log(new ar("c13122").ap("obj_type", 1));
                setData(1);
                Lp("2");
            }
        } else if (view == this.jRg && !y.isEmpty(com.baidu.tieba.frs.b.cBy().cBv())) {
            TiebaStatic.log(new ar("c13122").ap("obj_type", 2));
            setData(2);
            Lp("2");
        }
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.pageContext = tbPageContext;
    }

    private void Lp(String str) {
        if (this.pageContext != null) {
            if (this.jRi == null) {
                this.jRi = new f(this.pageContext, this);
            }
            this.jRi.Er(str);
        }
    }

    public void cEk() {
        if (this.jRi != null) {
            this.jRi.bKu();
        }
    }

    public void bKq() {
        if (this.jRi != null) {
            this.jRi.bKq();
        }
    }

    public void setData(int i) {
        if (this.pageContext != null) {
            if (this.jRi == null) {
                this.jRi = new f(this.pageContext, this);
            }
            SparseArray<String> sparseArray = new SparseArray<>();
            AntiData cBz = com.baidu.tieba.frs.b.cBy().cBz();
            if (cBz != null && cBz.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBz.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            List<cb> cBv = com.baidu.tieba.frs.b.cBy().cBv();
            for (int i3 = 0; i3 < cBv.size(); i3++) {
                jSONArray.put(cBv.get(i3).getTid());
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray);
            avVar.mX(i);
            avVar.P(jSONArray);
            avVar.setFid(com.baidu.tieba.frs.b.cBy().getForumId());
            this.jRi.setDefaultReasonArray(new String[]{getContext().getString(R.string.delete_thread_reason_1), getContext().getString(R.string.delete_thread_reason_2), getContext().getString(R.string.delete_thread_reason_3), getContext().getString(R.string.delete_thread_reason_4), getContext().getString(R.string.delete_thread_reason_5)});
            this.jRi.setData(avVar);
        }
    }

    public void onDestroy() {
        if (this.jRe != null) {
            this.jRe.a((e.a) null);
            this.jRe.onDestroy();
        }
    }

    public void setDeleteCallback(e.a aVar) {
        if (this.jRe != null) {
            this.jRe.a(aVar);
        }
    }
}
