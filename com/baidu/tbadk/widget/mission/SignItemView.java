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
    private LineView fNK;
    private ArrayList<b> fNL;
    private int fNN;
    private int fNO;
    private int fNP;
    private int fNQ;
    private a fOc;
    private LinearLayout mContainer;
    private int mSkinType;

    /* loaded from: classes21.dex */
    public interface a {
        void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    public SignItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fNL = new ArrayList<>();
        this.fNP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fNQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    public SignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fNL = new ArrayList<>();
        this.fNP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fNQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    public SignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fNL = new ArrayList<>();
        this.fNP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fNQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sign_dialog_cus_view, (ViewGroup) this, true);
        this.mContainer = (LinearLayout) findViewById(R.id.sign_item_container);
        this.fNK = (LineView) findViewById(R.id.line_view);
        this.fNN = l.getDimens(getContext(), R.dimen.tbds23);
        this.fNO = l.getDimens(getContext(), R.dimen.tbds26);
    }

    public void setItemClickListener(a aVar) {
        this.fOc = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.fNK.onChangeSkinType();
            Iterator<b> it = this.fNL.iterator();
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
                this.fNL.clear();
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (size <= 3) {
                        marginLayoutParams.leftMargin = this.fNO;
                        marginLayoutParams.rightMargin = this.fNO;
                    } else {
                        marginLayoutParams.leftMargin = this.fNN;
                        marginLayoutParams.rightMargin = this.fNN;
                    }
                    setLayoutParams(marginLayoutParams);
                }
                if (this.fNK.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fNK.getLayoutParams();
                    if (size <= 3) {
                        if (marginLayoutParams2.leftMargin != this.fNP || marginLayoutParams2.rightMargin != this.fNP) {
                            marginLayoutParams2.leftMargin = this.fNP;
                            marginLayoutParams2.rightMargin = this.fNP;
                            this.fNK.setLayoutParams(marginLayoutParams2);
                        }
                    } else if (marginLayoutParams2.leftMargin != this.fNQ || marginLayoutParams2.rightMargin != this.fNQ) {
                        marginLayoutParams2.leftMargin = this.fNQ;
                        marginLayoutParams2.rightMargin = this.fNQ;
                        this.fNK.setLayoutParams(marginLayoutParams2);
                    }
                }
                for (int i = 0; i < size; i++) {
                    this.fNL.add(c(arrayList.get(i)));
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
        bVar.fNY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.mission.SignItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!bVar.fOa) {
                    Iterator it = SignItemView.this.fNL.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).ll(false);
                    }
                    bVar.ll(true);
                    if (SignItemView.this.fOc == null) {
                        return;
                    }
                    SignItemView.this.fOc.b(bVar.fOb);
                }
            }
        });
        return bVar;
    }

    /* loaded from: classes21.dex */
    public static class b {
        private int fNX;
        private ImageView fNY;
        private CircleView fNZ;
        private ActiveCenterData.ActiveCenterStatusData fOb;
        private View itemView;
        private TextView textView;
        private int fNT = R.drawable.ic_pic_mask_task_complete_svg;
        private int fNU = R.drawable.ic_pic_mask_task_select_svg;
        private int fNV = R.drawable.ic_pic_mask_task_comingsoon_svg;
        private int fNW = R.drawable.ic_pic_mask_task_uncomplete_svg;
        private boolean fOa = false;

        public b(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            this.fNX = this.fNV;
            this.fOb = activeCenterStatusData;
            this.itemView = view;
            this.fNY = (ImageView) this.itemView.findViewById(R.id.item_icon);
            this.textView = (TextView) this.itemView.findViewById(R.id.item_text);
            this.fNZ = (CircleView) this.itemView.findViewById(R.id.select_circle);
            this.fNZ.setVisibility(4);
            if (activeCenterStatusData.is_today_mission == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.fNX = this.fNT;
                } else {
                    this.fNX = this.fNW;
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.fNZ.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.fNX = this.fNT;
                } else {
                    this.fNX = this.fNU;
                }
            } else {
                this.fNX = this.fNV;
            }
            SvgManager.btW().a(this.fNY, this.fNX, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.CAM_X0109);
            this.textView.setText(activeCenterStatusData.day + "天");
        }

        public void onChangeSkinType() {
            SvgManager.btW().a(this.fNY, this.fNX, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.CAM_X0109);
            this.fNZ.onChangeSkinType();
        }

        public void ll(boolean z) {
            if (z) {
                this.fOa = true;
                this.fNZ.setVisibility(0);
                return;
            }
            this.fOa = false;
            this.fNZ.setVisibility(4);
        }
    }
}
