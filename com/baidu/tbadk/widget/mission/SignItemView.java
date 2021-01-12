package com.baidu.tbadk.widget.mission;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class SignItemView extends FrameLayout {
    private LineView fSH;
    private ArrayList<b> fSI;
    private int fSK;
    private int fSL;
    private int fSM;
    private int fSN;
    private a fSY;
    private LinearLayout mContainer;
    private int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    public SignItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fSI = new ArrayList<>();
        this.fSM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fSN = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    public SignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fSI = new ArrayList<>();
        this.fSM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fSN = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    public SignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fSI = new ArrayList<>();
        this.fSM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fSN = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sign_dialog_cus_view, (ViewGroup) this, true);
        this.mContainer = (LinearLayout) findViewById(R.id.sign_item_container);
        this.fSH = (LineView) findViewById(R.id.line_view);
        this.fSK = l.getDimens(getContext(), R.dimen.tbds23);
        this.fSL = l.getDimens(getContext(), R.dimen.tbds26);
    }

    public void setItemClickListener(a aVar) {
        this.fSY = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.fSH.onChangeSkinType();
            Iterator<b> it = this.fSI.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType();
            }
        }
        this.mSkinType = i;
    }

    public void setData(ActiveCenterData activeCenterData) {
        if (activeCenterData != null) {
            ArrayList<ActiveCenterData.ActiveCenterStatusData> arrayList = activeCenterData.mission_status_list;
            int size = arrayList.size();
            if (arrayList != null && size != 0) {
                this.mContainer.removeAllViews();
                this.fSI.clear();
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (size <= 3) {
                        marginLayoutParams.leftMargin = this.fSL;
                        marginLayoutParams.rightMargin = this.fSL;
                    } else {
                        marginLayoutParams.leftMargin = this.fSK;
                        marginLayoutParams.rightMargin = this.fSK;
                    }
                    setLayoutParams(marginLayoutParams);
                }
                if (this.fSH.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fSH.getLayoutParams();
                    if (size <= 3) {
                        if (marginLayoutParams2.leftMargin != this.fSM || marginLayoutParams2.rightMargin != this.fSM) {
                            marginLayoutParams2.leftMargin = this.fSM;
                            marginLayoutParams2.rightMargin = this.fSM;
                            this.fSH.setLayoutParams(marginLayoutParams2);
                        }
                    } else if (marginLayoutParams2.leftMargin != this.fSN || marginLayoutParams2.rightMargin != this.fSN) {
                        marginLayoutParams2.leftMargin = this.fSN;
                        marginLayoutParams2.rightMargin = this.fSN;
                        this.fSH.setLayoutParams(marginLayoutParams2);
                    }
                }
                for (int i = 0; i < size; i++) {
                    this.fSI.add(c(arrayList.get(i)));
                }
            }
        }
    }

    private b c(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.sing_dialog_item_view, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        this.mContainer.addView(inflate, layoutParams);
        final b bVar = new b(inflate, activeCenterStatusData);
        bVar.iconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.mission.SignItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!bVar.fSW) {
                    Iterator it = SignItemView.this.fSI.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).lD(false);
                    }
                    bVar.lD(true);
                    if (SignItemView.this.fSY == null) {
                        return;
                    }
                    SignItemView.this.fSY.b(bVar.fSX);
                }
            }
        });
        return bVar;
    }

    /* loaded from: classes.dex */
    public static class b {
        private int fSU;
        private CircleView fSV;
        private ActiveCenterData.ActiveCenterStatusData fSX;
        private ImageView iconView;
        private View itemView;
        private TextView textView;
        private int fSQ = R.drawable.ic_pic_mask_task_complete_svg;
        private int fSR = R.drawable.ic_pic_mask_task_select_svg;
        private int fSS = R.drawable.ic_pic_mask_task_comingsoon_svg;
        private int fST = R.drawable.ic_pic_mask_task_uncomplete_svg;
        private boolean fSW = false;

        public b(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            this.fSU = this.fSS;
            this.fSX = activeCenterStatusData;
            this.itemView = view;
            this.iconView = (ImageView) this.itemView.findViewById(R.id.item_icon);
            this.textView = (TextView) this.itemView.findViewById(R.id.item_text);
            this.fSV = (CircleView) this.itemView.findViewById(R.id.select_circle);
            this.fSV.setVisibility(4);
            if (activeCenterStatusData.is_today_mission == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.fSU = this.fSQ;
                } else {
                    this.fSU = this.fST;
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.fSV.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.fSU = this.fSQ;
                } else {
                    this.fSU = this.fSR;
                }
            } else {
                this.fSU = this.fSS;
            }
            SvgManager.bsx().a(this.iconView, this.fSU, SvgManager.SvgResourceStateType.NORMAL);
            ao.setViewTextColor(this.textView, R.color.CAM_X0109);
            this.textView.setText(activeCenterStatusData.day + "天");
        }

        public void onChangeSkinType() {
            SvgManager.bsx().a(this.iconView, this.fSU, SvgManager.SvgResourceStateType.NORMAL);
            ao.setViewTextColor(this.textView, R.color.CAM_X0109);
            this.fSV.onChangeSkinType();
        }

        public void lD(boolean z) {
            if (z) {
                this.fSW = true;
                this.fSV.setVisibility(0);
                return;
            }
            this.fSW = false;
            this.fSV.setVisibility(4);
        }
    }
}
