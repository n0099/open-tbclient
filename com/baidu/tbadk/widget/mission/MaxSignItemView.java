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
public class MaxSignItemView extends FrameLayout {
    private int fWA;
    private int fWB;
    private int fWC;
    private LineView fWw;
    private ArrayList<b> fWx;
    private a fWy;
    private int fWz;
    private LinearLayout mContainer;
    private int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    public MaxSignItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fWx = new ArrayList<>();
        this.fWB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fWC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fWx = new ArrayList<>();
        this.fWB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fWC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fWx = new ArrayList<>();
        this.fWB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fWC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.max_sign_dialog_cus_view, (ViewGroup) this, true);
        this.mContainer = (LinearLayout) findViewById(R.id.sign_item_container);
        this.fWw = (LineView) findViewById(R.id.line_view);
        this.fWz = l.getDimens(getContext(), R.dimen.tbds3);
        this.fWA = l.getDimens(getContext(), R.dimen.tbds0);
    }

    public void setItemClickListener(a aVar) {
        this.fWy = aVar;
    }

    public void setData(ActiveCenterData activeCenterData) {
        if (activeCenterData != null) {
            ArrayList<ActiveCenterData.ActiveCenterStatusData> arrayList = activeCenterData.mission_status_list;
            int size = arrayList.size();
            if (arrayList != null && size != 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (size <= 3) {
                        if (marginLayoutParams.leftMargin != this.fWA || marginLayoutParams.rightMargin != this.fWA) {
                            marginLayoutParams.leftMargin = this.fWA;
                            marginLayoutParams.rightMargin = this.fWA;
                            setLayoutParams(marginLayoutParams);
                        }
                    } else if (marginLayoutParams.leftMargin != this.fWz || marginLayoutParams.rightMargin != this.fWz) {
                        marginLayoutParams.leftMargin = this.fWz;
                        marginLayoutParams.rightMargin = this.fWz;
                        setLayoutParams(layoutParams);
                    }
                }
                if (this.fWw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fWw.getLayoutParams();
                    if (size <= 3) {
                        if (marginLayoutParams2.leftMargin != this.fWB || marginLayoutParams2.rightMargin != this.fWB) {
                            marginLayoutParams2.leftMargin = this.fWB;
                            marginLayoutParams2.rightMargin = this.fWB;
                            this.fWw.setLayoutParams(marginLayoutParams2);
                        }
                    } else if (marginLayoutParams2.leftMargin != this.fWC || marginLayoutParams2.rightMargin != this.fWC) {
                        marginLayoutParams2.leftMargin = this.fWC;
                        marginLayoutParams2.rightMargin = this.fWC;
                        this.fWw.setLayoutParams(marginLayoutParams2);
                    }
                }
                this.mContainer.removeAllViews();
                this.fWx.clear();
                for (int i = 0; i < size; i++) {
                    this.fWx.add(a(arrayList.get(i)));
                }
            }
        }
    }

    private b a(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.max_sing_dialog_item_view, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        this.mContainer.addView(inflate, layoutParams);
        final b bVar = new b(inflate, activeCenterStatusData);
        bVar.iconView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.mission.MaxSignItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!bVar.fWL) {
                    Iterator it = MaxSignItemView.this.fWx.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).lH(false);
                    }
                    bVar.lH(true);
                    if (MaxSignItemView.this.fWy == null) {
                        return;
                    }
                    MaxSignItemView.this.fWy.b(bVar.fWM);
                }
            }
        });
        return bVar;
    }

    /* loaded from: classes.dex */
    public static class b {
        private int fWJ;
        private CircleView fWK;
        private ActiveCenterData.ActiveCenterStatusData fWM;
        private ImageView iconView;
        private View itemView;
        private TextView textView;
        private int fWF = R.drawable.ic_pic_mask_task_complete_svg;
        private int fWG = R.drawable.ic_pic_mask_task_select_svg;
        private int fWH = R.drawable.ic_pic_mask_task_comingsoon_svg;
        private int fWI = R.drawable.ic_pic_mask_task_uncomplete_svg;
        private boolean fWL = false;

        public b(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            this.fWJ = this.fWH;
            this.fWM = activeCenterStatusData;
            this.itemView = view;
            this.iconView = (ImageView) this.itemView.findViewById(R.id.item_icon);
            this.textView = (TextView) this.itemView.findViewById(R.id.item_text);
            this.fWK = (CircleView) this.itemView.findViewById(R.id.select_circle);
            this.fWK.setVisibility(4);
            if (activeCenterStatusData.is_today_mission == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.fWJ = this.fWF;
                } else {
                    this.fWJ = this.fWI;
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.fWK.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.fWJ = this.fWF;
                } else {
                    this.fWJ = this.fWG;
                }
            } else {
                this.fWJ = this.fWH;
            }
            SvgManager.bsU().a(this.iconView, this.fWJ, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.CAM_X0109);
            this.textView.setText(activeCenterStatusData.day + "天");
        }

        public void lH(boolean z) {
            if (z) {
                this.fWL = true;
                this.fWK.setVisibility(0);
                return;
            }
            this.fWL = false;
            this.fWK.setVisibility(4);
        }
    }
}
