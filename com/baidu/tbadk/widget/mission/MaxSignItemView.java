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
public class MaxSignItemView extends FrameLayout {
    private int fGA;
    private int fGB;
    private int fGC;
    private LineView fGw;
    private ArrayList<b> fGx;
    private a fGy;
    private int fGz;
    private LinearLayout mContainer;
    private int mSkinType;

    /* loaded from: classes21.dex */
    public interface a {
        void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    public MaxSignItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fGx = new ArrayList<>();
        this.fGB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fGC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fGx = new ArrayList<>();
        this.fGB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fGC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    public MaxSignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fGx = new ArrayList<>();
        this.fGB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds190);
        this.fGC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds115);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.max_sign_dialog_cus_view, (ViewGroup) this, true);
        this.mContainer = (LinearLayout) findViewById(R.id.sign_item_container);
        this.fGw = (LineView) findViewById(R.id.line_view);
        this.fGz = l.getDimens(getContext(), R.dimen.tbds3);
        this.fGA = l.getDimens(getContext(), R.dimen.tbds0);
    }

    public void setItemClickListener(a aVar) {
        this.fGy = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.fGw.onChangeSkinType();
            Iterator<b> it = this.fGx.iterator();
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
                        if (marginLayoutParams.leftMargin != this.fGA || marginLayoutParams.rightMargin != this.fGA) {
                            marginLayoutParams.leftMargin = this.fGA;
                            marginLayoutParams.rightMargin = this.fGA;
                            setLayoutParams(marginLayoutParams);
                        }
                    } else if (marginLayoutParams.leftMargin != this.fGz || marginLayoutParams.rightMargin != this.fGz) {
                        marginLayoutParams.leftMargin = this.fGz;
                        marginLayoutParams.rightMargin = this.fGz;
                        setLayoutParams(layoutParams);
                    }
                }
                if (this.fGw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.fGw.getLayoutParams();
                    if (size <= 3) {
                        if (marginLayoutParams2.leftMargin != this.fGB || marginLayoutParams2.rightMargin != this.fGB) {
                            marginLayoutParams2.leftMargin = this.fGB;
                            marginLayoutParams2.rightMargin = this.fGB;
                            this.fGw.setLayoutParams(marginLayoutParams2);
                        }
                    } else if (marginLayoutParams2.leftMargin != this.fGC || marginLayoutParams2.rightMargin != this.fGC) {
                        marginLayoutParams2.leftMargin = this.fGC;
                        marginLayoutParams2.rightMargin = this.fGC;
                        this.fGw.setLayoutParams(marginLayoutParams2);
                    }
                }
                this.mContainer.removeAllViews();
                this.fGx.clear();
                for (int i = 0; i < size; i++) {
                    this.fGx.add(a(arrayList.get(i)));
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
        bVar.fGK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.mission.MaxSignItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!bVar.fGM) {
                    Iterator it = MaxSignItemView.this.fGx.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).kQ(false);
                    }
                    bVar.kQ(true);
                    if (MaxSignItemView.this.fGy == null) {
                        return;
                    }
                    MaxSignItemView.this.fGy.b(bVar.fGN);
                }
            }
        });
        return bVar;
    }

    /* loaded from: classes21.dex */
    public static class b {
        private int fGJ;
        private ImageView fGK;
        private CircleView fGL;
        private ActiveCenterData.ActiveCenterStatusData fGN;
        private View itemView;
        private TextView textView;
        private int fGF = R.drawable.ic_pic_mask_task_complete_svg;
        private int fGG = R.drawable.ic_pic_mask_task_select_svg;
        private int fGH = R.drawable.ic_pic_mask_task_comingsoon_svg;
        private int fGI = R.drawable.ic_pic_mask_task_uncomplete_svg;
        private boolean fGM = false;

        public b(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            this.fGJ = this.fGH;
            this.fGN = activeCenterStatusData;
            this.itemView = view;
            this.fGK = (ImageView) this.itemView.findViewById(R.id.item_icon);
            this.textView = (TextView) this.itemView.findViewById(R.id.item_text);
            this.fGL = (CircleView) this.itemView.findViewById(R.id.select_circle);
            this.fGL.setVisibility(4);
            if (activeCenterStatusData.is_today_mission == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.fGJ = this.fGF;
                } else {
                    this.fGJ = this.fGI;
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.fGL.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.fGJ = this.fGF;
                } else {
                    this.fGJ = this.fGG;
                }
            } else {
                this.fGJ = this.fGH;
            }
            SvgManager.brn().a(this.fGK, this.fGJ, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.cp_cont_d);
            this.textView.setText(activeCenterStatusData.day + "天");
        }

        public void onChangeSkinType() {
            SvgManager.brn().a(this.fGK, this.fGJ, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.cp_cont_d);
            this.fGL.onChangeSkinType();
        }

        public void kQ(boolean z) {
            if (z) {
                this.fGM = true;
                this.fGL.setVisibility(0);
                return;
            }
            this.fGM = false;
            this.fGL.setVisibility(4);
        }
    }
}
