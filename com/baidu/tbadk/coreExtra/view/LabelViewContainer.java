package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class LabelViewContainer extends LinearLayout {
    private AutoLinearLayout alI;
    private TextView alJ;
    private LinearLayout.LayoutParams alK;
    private a alL;
    private RelativeLayout alM;
    private List<RelativeLayout> alN;
    private String alO;
    private List<Map<String, Object>> alP;
    private int alQ;
    private int alR;
    private boolean alS;
    private boolean alT;
    private RelativeLayout alU;
    private TextView alV;
    private ViewTreeObserver.OnGlobalLayoutListener alW;
    private View.OnClickListener alX;
    private View.OnClickListener alY;
    private Context context;
    private boolean isEditState;
    private TextView label_name;

    /* loaded from: classes.dex */
    public interface a {
        void showAddHotIconCallback(View view);
    }

    public LabelViewContainer(Context context) {
        super(context, null);
        this.alN = null;
        this.alO = "";
        this.isEditState = false;
        this.alS = false;
        this.alT = true;
        this.alW = new o(this);
        this.context = context;
        LayoutInflater.from(context).inflate(i.g.label_container_layout, (ViewGroup) this, true);
        this.alK = new LinearLayout.LayoutParams(-1, -1);
        this.alI = (AutoLinearLayout) findViewById(i.f.auto_linear_layout);
        this.alI.setLayoutParams(this.alK);
        this.alJ = (TextView) findViewById(i.f.container_title);
        this.alP = new ArrayList();
        this.alN = new ArrayList();
    }

    public LabelViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.alN = null;
        this.alO = "";
        this.isEditState = false;
        this.alS = false;
        this.alT = true;
        this.alW = new o(this);
        this.context = context;
        LayoutInflater.from(context).inflate(i.g.label_container_layout, (ViewGroup) this, true);
        this.alI = (AutoLinearLayout) findViewById(i.f.auto_linear_layout);
        this.alK = new LinearLayout.LayoutParams(-1, -2);
        this.alI.setLayoutParams(this.alK);
        this.alJ = (TextView) findViewById(i.f.container_title);
        this.alP = new ArrayList();
        this.alN = new ArrayList();
    }

    public void setTitleName(String str) {
        this.alJ.setText(str);
    }

    public void setTitleVisibility(boolean z) {
        if (z) {
            this.alJ.setVisibility(0);
        } else {
            this.alJ.setVisibility(8);
        }
    }

    public void aS(boolean z) {
        this.alT = z;
    }

    public void setData(ArrayList<p> arrayList) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                HashMap hashMap = new HashMap();
                hashMap.put("label_info", arrayList.get(i));
                this.alP.add(hashMap);
            }
        }
    }

    public void initView() {
        if (this.alP != null) {
            this.alI.removeAllViews();
            for (int i = 0; i < this.alP.size(); i++) {
                RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.context).inflate(i.g.thread_expression_label_item_view, (ViewGroup) null);
                this.label_name = (TextView) relativeLayout.findViewById(i.f.label_name);
                this.alU = (RelativeLayout) relativeLayout.findViewById(i.f.label_item);
                this.alV = (TextView) relativeLayout.findViewById(i.f.label_hot_value);
                p pVar = (p) this.alP.get(i).get("label_info");
                if (pVar != null && pVar.getLabelName() != null && pVar.zl() != null) {
                    String labelName = pVar.getLabelName();
                    if (com.baidu.tbadk.util.k.fJ(labelName) > 10) {
                        labelName = String.valueOf(com.baidu.tbadk.util.k.f(labelName, 0, 9)) + "...";
                    }
                    this.label_name.setText(labelName);
                    if (pVar.zj() != 0) {
                        this.alV.setVisibility(0);
                        this.alV.setText(aq.r(pVar.zj()));
                    } else {
                        this.alV.setVisibility(8);
                    }
                    int skinType = TbadkCoreApplication.m411getInst().getSkinType();
                    if (this.isEditState) {
                        if (pVar.zm()) {
                            al.c(this.alU, i.e.thread_expression_delete_clicked_item_selector, skinType);
                            al.b(this.label_name, i.c.cp_cont_h, 1);
                            al.b(this.alV, i.c.cp_cont_h, 1);
                        } else {
                            al.c(this.alU, i.e.thread_expression_item_selector, skinType);
                            al.b(this.label_name, i.c.cp_cont_f, 1);
                            al.b(this.alV, i.c.cp_other_e, 1);
                        }
                    } else {
                        if (pVar.zk()) {
                            al.c(this.alU, i.e.thread_expression_clicked_item_selector, skinType);
                            al.b(this.label_name, i.c.cp_other_e, 1);
                        } else {
                            al.c(this.alU, i.e.thread_expression_item_selector, skinType);
                            al.b(this.label_name, i.c.cp_cont_f, 1);
                        }
                        al.b(this.alV, i.c.cp_other_e, 1);
                    }
                    this.alN.add(relativeLayout);
                    this.alI.addView(relativeLayout);
                    if (!this.isEditState && this.alO != null && this.alO.equals(pVar.zl())) {
                        this.alM = this.alU;
                        this.alM.getViewTreeObserver().addOnGlobalLayoutListener(this.alW);
                        pVar.a(this.alW);
                    }
                    this.alU.setTag(pVar);
                    if (this.alT) {
                        this.alU.setOnClickListener(this.alX);
                        this.alU.setClickable(true);
                    } else {
                        al.c(this.alU, i.e.btn_label_white_n, skinType);
                        this.alU.setOnClickListener(null);
                        this.alU.setClickable(false);
                    }
                } else {
                    return;
                }
            }
            aT(this.isEditState);
        }
    }

    private void aT(boolean z) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.context).inflate(i.g.thread_expression_label_item_view, (ViewGroup) null);
        this.label_name = (TextView) relativeLayout.findViewById(i.f.label_name);
        this.label_name.setText(this.context.getResources().getString(i.h.add_expression_item));
        this.alV = (TextView) relativeLayout.findViewById(i.f.label_hot_value);
        this.alV.setVisibility(8);
        relativeLayout.setGravity(17);
        if ((this.alR > 0 && this.alQ > 0) || this.alS) {
            al.b(this.label_name, i.c.cp_other_e, 1);
            al.h(relativeLayout, i.e.thread_expression_add_selector);
            if (this.alT) {
                relativeLayout.setOnClickListener(this.alY);
                relativeLayout.setClickable(true);
            } else {
                relativeLayout.setOnClickListener(null);
                relativeLayout.setClickable(false);
                al.h(relativeLayout, i.e.btn_label_yinxiang_n);
            }
        } else {
            al.b(this.label_name, i.c.cp_cont_e, 1);
            al.c(relativeLayout, i.e.btn_label_yinxiang_d, 1);
            relativeLayout.setOnClickListener(this.alY);
            relativeLayout.setClickable(true);
        }
        this.alI.addView(relativeLayout);
        if (z) {
            relativeLayout.setVisibility(4);
        } else {
            relativeLayout.setVisibility(0);
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.alX = onClickListener;
    }

    public void setAddExpressionClickListener(View.OnClickListener onClickListener) {
        this.alY = onClickListener;
    }

    public void setAvailabelNum(int i) {
        this.alQ = i;
    }

    public int getAvailabelNum() {
        return this.alQ;
    }

    public void setLeftlNum(int i) {
        this.alR = i;
    }

    public int getLeftlNum() {
        return this.alR;
    }

    public void clear() {
        if (this.alP != null) {
            this.alP.clear();
        }
    }

    public void setEditState(boolean z) {
        this.isEditState = z;
    }

    public void setShowAddHotIconCallback(a aVar) {
        this.alL = aVar;
    }

    public void setSelectedLabelId(String str) {
        this.alO = str;
    }

    public String getSelectedLabelId() {
        return this.alO;
    }

    public void setIsAddViewEditState(boolean z) {
        this.alS = z;
    }

    public void setShowColumns(int i) {
        this.alI.setShowColumns(i);
    }

    public void setMarginRight(int i) {
        this.alI.setMarginRight(i);
    }

    public void setParentWidth(int i) {
        this.alI.setParentWidth(i);
    }
}
