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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes21.dex */
public class SignItemView extends FrameLayout {
    private LineView fAG;
    private ArrayList<b> fAH;
    private int fAJ;
    private int fAK;
    private int fAL;
    private int fAM;
    private a fAY;
    private LinearLayout mContainer;
    private int mSkinType;

    /* loaded from: classes21.dex */
    public interface a {
        void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    public SignItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fAH = new ArrayList<>();
        this.fAL = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fAM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    public SignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fAH = new ArrayList<>();
        this.fAL = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fAM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    public SignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fAH = new ArrayList<>();
        this.fAL = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fAM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sign_dialog_cus_view, (ViewGroup) this, true);
        this.mContainer = (LinearLayout) findViewById(R.id.sign_item_container);
        this.fAG = (LineView) findViewById(R.id.line_view);
        this.fAJ = l.getDimens(getContext(), R.dimen.tbds23);
        this.fAK = l.getDimens(getContext(), R.dimen.tbds26);
    }

    public void setItemClickListener(a aVar) {
        this.fAY = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.fAG.onChangeSkinType();
            Iterator<b> it = this.fAH.iterator();
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
                this.fAH.clear();
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (size <= 3) {
                        marginLayoutParams.leftMargin = this.fAK;
                        marginLayoutParams.rightMargin = this.fAK;
                    } else {
                        marginLayoutParams.leftMargin = this.fAJ;
                        marginLayoutParams.rightMargin = this.fAJ;
                    }
                    setLayoutParams(marginLayoutParams);
                }
                if (this.fAG.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fAG.getLayoutParams();
                    if (size <= 3) {
                        if (marginLayoutParams2.leftMargin != this.fAL || marginLayoutParams2.rightMargin != this.fAL) {
                            marginLayoutParams2.leftMargin = this.fAL;
                            marginLayoutParams2.rightMargin = this.fAL;
                            this.fAG.setLayoutParams(marginLayoutParams2);
                        }
                    } else if (marginLayoutParams2.leftMargin != this.fAM || marginLayoutParams2.rightMargin != this.fAM) {
                        marginLayoutParams2.leftMargin = this.fAM;
                        marginLayoutParams2.rightMargin = this.fAM;
                        this.fAG.setLayoutParams(marginLayoutParams2);
                    }
                }
                for (int i = 0; i < size; i++) {
                    this.fAH.add(c(arrayList.get(i)));
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
        bVar.fAU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.mission.SignItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!bVar.fAW) {
                    Iterator it = SignItemView.this.fAH.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).kH(false);
                    }
                    bVar.kH(true);
                    if (SignItemView.this.fAY == null) {
                        return;
                    }
                    SignItemView.this.fAY.b(bVar.fAX);
                }
            }
        });
        return bVar;
    }

    /* loaded from: classes21.dex */
    public static class b {
        private int fAT;
        private ImageView fAU;
        private CircleView fAV;
        private ActiveCenterData.ActiveCenterStatusData fAX;
        private View itemView;
        private TextView textView;
        private int fAP = R.drawable.ic_pic_mask_task_complete_svg;
        private int fAQ = R.drawable.ic_pic_mask_task_select_svg;
        private int fAR = R.drawable.ic_pic_mask_task_comingsoon_svg;
        private int fAS = R.drawable.ic_pic_mask_task_uncomplete_svg;
        private boolean fAW = false;

        public b(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            this.fAT = this.fAR;
            this.fAX = activeCenterStatusData;
            this.itemView = view;
            this.fAU = (ImageView) this.itemView.findViewById(R.id.item_icon);
            this.textView = (TextView) this.itemView.findViewById(R.id.item_text);
            this.fAV = (CircleView) this.itemView.findViewById(R.id.select_circle);
            this.fAV.setVisibility(4);
            if (activeCenterStatusData.is_today_mission == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.fAT = this.fAP;
                } else {
                    this.fAT = this.fAS;
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.fAV.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.fAT = this.fAP;
                } else {
                    this.fAT = this.fAQ;
                }
            } else {
                this.fAT = this.fAR;
            }
            SvgManager.boN().a(this.fAU, this.fAT, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.cp_cont_d);
            this.textView.setText(activeCenterStatusData.day + "天");
        }

        public void onChangeSkinType() {
            SvgManager.boN().a(this.fAU, this.fAT, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.cp_cont_d);
            this.fAV.onChangeSkinType();
        }

        public void kH(boolean z) {
            if (z) {
                this.fAW = true;
                this.fAV.setVisibility(0);
                return;
            }
            this.fAW = false;
            this.fAV.setVisibility(4);
        }
    }
}
