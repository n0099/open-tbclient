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
/* loaded from: classes.dex */
public class SignItemView extends FrameLayout {
    private LineView fUW;
    private ArrayList<b> fUX;
    private int fUZ;
    private int fVa;
    private int fVb;
    private int fVc;
    private a fVn;
    private LinearLayout mContainer;
    private int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    public SignItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fUX = new ArrayList<>();
        this.fVb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fVc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    public SignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fUX = new ArrayList<>();
        this.fVb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fVc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    public SignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fUX = new ArrayList<>();
        this.fVb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fVc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sign_dialog_cus_view, (ViewGroup) this, true);
        this.mContainer = (LinearLayout) findViewById(R.id.sign_item_container);
        this.fUW = (LineView) findViewById(R.id.line_view);
        this.fUZ = l.getDimens(getContext(), R.dimen.tbds23);
        this.fVa = l.getDimens(getContext(), R.dimen.tbds26);
    }

    public void setItemClickListener(a aVar) {
        this.fVn = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.fUW.onChangeSkinType();
            Iterator<b> it = this.fUX.iterator();
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
                this.fUX.clear();
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (size <= 3) {
                        marginLayoutParams.leftMargin = this.fVa;
                        marginLayoutParams.rightMargin = this.fVa;
                    } else {
                        marginLayoutParams.leftMargin = this.fUZ;
                        marginLayoutParams.rightMargin = this.fUZ;
                    }
                    setLayoutParams(marginLayoutParams);
                }
                if (this.fUW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fUW.getLayoutParams();
                    if (size <= 3) {
                        if (marginLayoutParams2.leftMargin != this.fVb || marginLayoutParams2.rightMargin != this.fVb) {
                            marginLayoutParams2.leftMargin = this.fVb;
                            marginLayoutParams2.rightMargin = this.fVb;
                            this.fUW.setLayoutParams(marginLayoutParams2);
                        }
                    } else if (marginLayoutParams2.leftMargin != this.fVc || marginLayoutParams2.rightMargin != this.fVc) {
                        marginLayoutParams2.leftMargin = this.fVc;
                        marginLayoutParams2.rightMargin = this.fVc;
                        this.fUW.setLayoutParams(marginLayoutParams2);
                    }
                }
                for (int i = 0; i < size; i++) {
                    this.fUX.add(c(arrayList.get(i)));
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
                if (!bVar.fVl) {
                    Iterator it = SignItemView.this.fUX.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).lH(false);
                    }
                    bVar.lH(true);
                    if (SignItemView.this.fVn == null) {
                        return;
                    }
                    SignItemView.this.fVn.b(bVar.fVm);
                }
            }
        });
        return bVar;
    }

    /* loaded from: classes.dex */
    public static class b {
        private int fVj;
        private CircleView fVk;
        private ActiveCenterData.ActiveCenterStatusData fVm;
        private ImageView iconView;
        private View itemView;
        private TextView textView;
        private int fVf = R.drawable.ic_pic_mask_task_complete_svg;
        private int fVg = R.drawable.ic_pic_mask_task_select_svg;
        private int fVh = R.drawable.ic_pic_mask_task_comingsoon_svg;
        private int fVi = R.drawable.ic_pic_mask_task_uncomplete_svg;
        private boolean fVl = false;

        public b(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            this.fVj = this.fVh;
            this.fVm = activeCenterStatusData;
            this.itemView = view;
            this.iconView = (ImageView) this.itemView.findViewById(R.id.item_icon);
            this.textView = (TextView) this.itemView.findViewById(R.id.item_text);
            this.fVk = (CircleView) this.itemView.findViewById(R.id.select_circle);
            this.fVk.setVisibility(4);
            if (activeCenterStatusData.is_today_mission == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.fVj = this.fVf;
                } else {
                    this.fVj = this.fVi;
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.fVk.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.fVj = this.fVf;
                } else {
                    this.fVj = this.fVg;
                }
            } else {
                this.fVj = this.fVh;
            }
            SvgManager.bsR().a(this.iconView, this.fVj, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.CAM_X0109);
            this.textView.setText(activeCenterStatusData.day + "天");
        }

        public void onChangeSkinType() {
            SvgManager.bsR().a(this.iconView, this.fVj, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.CAM_X0109);
            this.fVk.onChangeSkinType();
        }

        public void lH(boolean z) {
            if (z) {
                this.fVl = true;
                this.fVk.setVisibility(0);
                return;
            }
            this.fVl = false;
            this.fVk.setVisibility(4);
        }
    }
}
