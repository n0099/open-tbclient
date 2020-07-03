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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class MaxSignItemView extends FrameLayout {
    private LineView eLW;
    private ArrayList<b> eLX;
    private a eLY;
    private int eLZ;
    private int eMa;
    private int eMb;
    private int eMc;
    private LinearLayout mContainer;
    private int mSkinType;

    /* loaded from: classes8.dex */
    public interface a {
        void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    public MaxSignItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eLX = new ArrayList<>();
        this.eMb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.eMc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eLX = new ArrayList<>();
        this.eMb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.eMc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eLX = new ArrayList<>();
        this.eMb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.eMc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.max_sign_dialog_cus_view, (ViewGroup) this, true);
        this.mContainer = (LinearLayout) findViewById(R.id.sign_item_container);
        this.eLW = (LineView) findViewById(R.id.line_view);
        this.eLZ = l.getDimens(getContext(), R.dimen.tbds3);
        this.eMa = l.getDimens(getContext(), R.dimen.tbds0);
    }

    public void setItemClickListener(a aVar) {
        this.eLY = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.eLW.onChangeSkinType();
            Iterator<b> it = this.eLX.iterator();
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
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (size <= 3) {
                        if (marginLayoutParams.leftMargin != this.eMa || marginLayoutParams.rightMargin != this.eMa) {
                            marginLayoutParams.leftMargin = this.eMa;
                            marginLayoutParams.rightMargin = this.eMa;
                            setLayoutParams(marginLayoutParams);
                        }
                    } else if (marginLayoutParams.leftMargin != this.eLZ || marginLayoutParams.rightMargin != this.eLZ) {
                        marginLayoutParams.leftMargin = this.eLZ;
                        marginLayoutParams.rightMargin = this.eLZ;
                        setLayoutParams(layoutParams);
                    }
                }
                if (this.eLW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.eLW.getLayoutParams();
                    if (size <= 3) {
                        if (marginLayoutParams2.leftMargin != this.eMb || marginLayoutParams2.rightMargin != this.eMb) {
                            marginLayoutParams2.leftMargin = this.eMb;
                            marginLayoutParams2.rightMargin = this.eMb;
                            this.eLW.setLayoutParams(marginLayoutParams2);
                        }
                    } else if (marginLayoutParams2.leftMargin != this.eMc || marginLayoutParams2.rightMargin != this.eMc) {
                        marginLayoutParams2.leftMargin = this.eMc;
                        marginLayoutParams2.rightMargin = this.eMc;
                        this.eLW.setLayoutParams(marginLayoutParams2);
                    }
                }
                this.mContainer.removeAllViews();
                this.eLX.clear();
                for (int i = 0; i < size; i++) {
                    this.eLX.add(a(arrayList.get(i)));
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
        bVar.eMk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.mission.MaxSignItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!bVar.eMm) {
                    Iterator it = MaxSignItemView.this.eLX.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).iQ(false);
                    }
                    bVar.iQ(true);
                    if (MaxSignItemView.this.eLY == null) {
                        return;
                    }
                    MaxSignItemView.this.eLY.b(bVar.eMn);
                }
            }
        });
        return bVar;
    }

    /* loaded from: classes8.dex */
    public static class b {
        private int eMj;
        private ImageView eMk;
        private CircleView eMl;
        private ActiveCenterData.ActiveCenterStatusData eMn;
        private View itemView;
        private TextView textView;
        private int eMf = R.drawable.ic_pic_mask_task_complete_svg;
        private int eMg = R.drawable.ic_pic_mask_task_select_svg;
        private int eMh = R.drawable.ic_pic_mask_task_comingsoon_svg;
        private int eMi = R.drawable.ic_pic_mask_task_uncomplete_svg;
        private boolean eMm = false;

        public b(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            this.eMj = this.eMh;
            this.eMn = activeCenterStatusData;
            this.itemView = view;
            this.eMk = (ImageView) this.itemView.findViewById(R.id.item_icon);
            this.textView = (TextView) this.itemView.findViewById(R.id.item_text);
            this.eMl = (CircleView) this.itemView.findViewById(R.id.select_circle);
            this.eMl.setVisibility(4);
            if (activeCenterStatusData.is_today_mission == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.eMj = this.eMf;
                } else {
                    this.eMj = this.eMi;
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.eMl.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.eMj = this.eMf;
                } else {
                    this.eMj = this.eMg;
                }
            } else {
                this.eMj = this.eMh;
            }
            SvgManager.aWQ().a(this.eMk, this.eMj, SvgManager.SvgResourceStateType.NORMAL);
            an.setViewTextColor(this.textView, (int) R.color.cp_cont_d);
            this.textView.setText(activeCenterStatusData.day + "天");
        }

        public void onChangeSkinType() {
            SvgManager.aWQ().a(this.eMk, this.eMj, SvgManager.SvgResourceStateType.NORMAL);
            an.setViewTextColor(this.textView, (int) R.color.cp_cont_d);
            this.eMl.onChangeSkinType();
        }

        public void iQ(boolean z) {
            if (z) {
                this.eMm = true;
                this.eMl.setVisibility(0);
                return;
            }
            this.eMm = false;
            this.eMl.setVisibility(4);
        }
    }
}
