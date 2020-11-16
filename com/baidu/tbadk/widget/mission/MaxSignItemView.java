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
/* loaded from: classes20.dex */
public class MaxSignItemView extends FrameLayout {
    private LineView fFY;
    private ArrayList<b> fFZ;
    private a fGa;
    private int fGb;
    private int fGc;
    private int fGd;
    private int fGe;
    private LinearLayout mContainer;
    private int mSkinType;

    /* loaded from: classes20.dex */
    public interface a {
        void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    public MaxSignItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fFZ = new ArrayList<>();
        this.fGd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fGe = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fFZ = new ArrayList<>();
        this.fGd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fGe = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fFZ = new ArrayList<>();
        this.fGd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fGe = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.max_sign_dialog_cus_view, (ViewGroup) this, true);
        this.mContainer = (LinearLayout) findViewById(R.id.sign_item_container);
        this.fFY = (LineView) findViewById(R.id.line_view);
        this.fGb = l.getDimens(getContext(), R.dimen.tbds3);
        this.fGc = l.getDimens(getContext(), R.dimen.tbds0);
    }

    public void setItemClickListener(a aVar) {
        this.fGa = aVar;
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
                        if (marginLayoutParams.leftMargin != this.fGc || marginLayoutParams.rightMargin != this.fGc) {
                            marginLayoutParams.leftMargin = this.fGc;
                            marginLayoutParams.rightMargin = this.fGc;
                            setLayoutParams(marginLayoutParams);
                        }
                    } else if (marginLayoutParams.leftMargin != this.fGb || marginLayoutParams.rightMargin != this.fGb) {
                        marginLayoutParams.leftMargin = this.fGb;
                        marginLayoutParams.rightMargin = this.fGb;
                        setLayoutParams(layoutParams);
                    }
                }
                if (this.fFY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fFY.getLayoutParams();
                    if (size <= 3) {
                        if (marginLayoutParams2.leftMargin != this.fGd || marginLayoutParams2.rightMargin != this.fGd) {
                            marginLayoutParams2.leftMargin = this.fGd;
                            marginLayoutParams2.rightMargin = this.fGd;
                            this.fFY.setLayoutParams(marginLayoutParams2);
                        }
                    } else if (marginLayoutParams2.leftMargin != this.fGe || marginLayoutParams2.rightMargin != this.fGe) {
                        marginLayoutParams2.leftMargin = this.fGe;
                        marginLayoutParams2.rightMargin = this.fGe;
                        this.fFY.setLayoutParams(marginLayoutParams2);
                    }
                }
                this.mContainer.removeAllViews();
                this.fFZ.clear();
                for (int i = 0; i < size; i++) {
                    this.fFZ.add(a(arrayList.get(i)));
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
        bVar.fGm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.mission.MaxSignItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!bVar.fGo) {
                    Iterator it = MaxSignItemView.this.fFZ.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).kR(false);
                    }
                    bVar.kR(true);
                    if (MaxSignItemView.this.fGa == null) {
                        return;
                    }
                    MaxSignItemView.this.fGa.b(bVar.fGp);
                }
            }
        });
        return bVar;
    }

    /* loaded from: classes20.dex */
    public static class b {
        private int fGl;
        private ImageView fGm;
        private CircleView fGn;
        private ActiveCenterData.ActiveCenterStatusData fGp;
        private View itemView;
        private TextView textView;
        private int fGh = R.drawable.ic_pic_mask_task_complete_svg;
        private int fGi = R.drawable.ic_pic_mask_task_select_svg;
        private int fGj = R.drawable.ic_pic_mask_task_comingsoon_svg;
        private int fGk = R.drawable.ic_pic_mask_task_uncomplete_svg;
        private boolean fGo = false;

        public b(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            this.fGl = this.fGj;
            this.fGp = activeCenterStatusData;
            this.itemView = view;
            this.fGm = (ImageView) this.itemView.findViewById(R.id.item_icon);
            this.textView = (TextView) this.itemView.findViewById(R.id.item_text);
            this.fGn = (CircleView) this.itemView.findViewById(R.id.select_circle);
            this.fGn.setVisibility(4);
            if (activeCenterStatusData.is_today_mission == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.fGl = this.fGh;
                } else {
                    this.fGl = this.fGk;
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.fGn.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.fGl = this.fGh;
                } else {
                    this.fGl = this.fGi;
                }
            } else {
                this.fGl = this.fGj;
            }
            SvgManager.bqB().a(this.fGm, this.fGl, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.CAM_X0109);
            this.textView.setText(activeCenterStatusData.day + "天");
        }

        public void kR(boolean z) {
            if (z) {
                this.fGo = true;
                this.fGn.setVisibility(0);
                return;
            }
            this.fGo = false;
            this.fGn.setVisibility(4);
        }
    }
}
