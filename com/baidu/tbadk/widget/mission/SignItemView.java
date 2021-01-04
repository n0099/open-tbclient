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
    private a fXF;
    private LineView fXo;
    private ArrayList<b> fXp;
    private int fXr;
    private int fXs;
    private int fXt;
    private int fXu;
    private LinearLayout mContainer;
    private int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    public SignItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fXp = new ArrayList<>();
        this.fXt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fXu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    public SignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fXp = new ArrayList<>();
        this.fXt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fXu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    public SignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fXp = new ArrayList<>();
        this.fXt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fXu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sign_dialog_cus_view, (ViewGroup) this, true);
        this.mContainer = (LinearLayout) findViewById(R.id.sign_item_container);
        this.fXo = (LineView) findViewById(R.id.line_view);
        this.fXr = l.getDimens(getContext(), R.dimen.tbds23);
        this.fXs = l.getDimens(getContext(), R.dimen.tbds26);
    }

    public void setItemClickListener(a aVar) {
        this.fXF = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.fXo.onChangeSkinType();
            Iterator<b> it = this.fXp.iterator();
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
                this.fXp.clear();
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (size <= 3) {
                        marginLayoutParams.leftMargin = this.fXs;
                        marginLayoutParams.rightMargin = this.fXs;
                    } else {
                        marginLayoutParams.leftMargin = this.fXr;
                        marginLayoutParams.rightMargin = this.fXr;
                    }
                    setLayoutParams(marginLayoutParams);
                }
                if (this.fXo.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fXo.getLayoutParams();
                    if (size <= 3) {
                        if (marginLayoutParams2.leftMargin != this.fXt || marginLayoutParams2.rightMargin != this.fXt) {
                            marginLayoutParams2.leftMargin = this.fXt;
                            marginLayoutParams2.rightMargin = this.fXt;
                            this.fXo.setLayoutParams(marginLayoutParams2);
                        }
                    } else if (marginLayoutParams2.leftMargin != this.fXu || marginLayoutParams2.rightMargin != this.fXu) {
                        marginLayoutParams2.leftMargin = this.fXu;
                        marginLayoutParams2.rightMargin = this.fXu;
                        this.fXo.setLayoutParams(marginLayoutParams2);
                    }
                }
                for (int i = 0; i < size; i++) {
                    this.fXp.add(c(arrayList.get(i)));
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
                if (!bVar.fXD) {
                    Iterator it = SignItemView.this.fXp.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).lH(false);
                    }
                    bVar.lH(true);
                    if (SignItemView.this.fXF == null) {
                        return;
                    }
                    SignItemView.this.fXF.b(bVar.fXE);
                }
            }
        });
        return bVar;
    }

    /* loaded from: classes.dex */
    public static class b {
        private int fXB;
        private CircleView fXC;
        private ActiveCenterData.ActiveCenterStatusData fXE;
        private ImageView iconView;
        private View itemView;
        private TextView textView;
        private int fXx = R.drawable.ic_pic_mask_task_complete_svg;
        private int fXy = R.drawable.ic_pic_mask_task_select_svg;
        private int fXz = R.drawable.ic_pic_mask_task_comingsoon_svg;
        private int fXA = R.drawable.ic_pic_mask_task_uncomplete_svg;
        private boolean fXD = false;

        public b(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            this.fXB = this.fXz;
            this.fXE = activeCenterStatusData;
            this.itemView = view;
            this.iconView = (ImageView) this.itemView.findViewById(R.id.item_icon);
            this.textView = (TextView) this.itemView.findViewById(R.id.item_text);
            this.fXC = (CircleView) this.itemView.findViewById(R.id.select_circle);
            this.fXC.setVisibility(4);
            if (activeCenterStatusData.is_today_mission == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.fXB = this.fXx;
                } else {
                    this.fXB = this.fXA;
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.fXC.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.fXB = this.fXx;
                } else {
                    this.fXB = this.fXy;
                }
            } else {
                this.fXB = this.fXz;
            }
            SvgManager.bwq().a(this.iconView, this.fXB, SvgManager.SvgResourceStateType.NORMAL);
            ao.setViewTextColor(this.textView, R.color.CAM_X0109);
            this.textView.setText(activeCenterStatusData.day + "天");
        }

        public void onChangeSkinType() {
            SvgManager.bwq().a(this.iconView, this.fXB, SvgManager.SvgResourceStateType.NORMAL);
            ao.setViewTextColor(this.textView, R.color.CAM_X0109);
            this.fXC.onChangeSkinType();
        }

        public void lH(boolean z) {
            if (z) {
                this.fXD = true;
                this.fXC.setVisibility(0);
                return;
            }
            this.fXD = false;
            this.fXC.setVisibility(4);
        }
    }
}
