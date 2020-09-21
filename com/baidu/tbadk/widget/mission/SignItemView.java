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
public class SignItemView extends FrameLayout {
    private LineView ffU;
    private ArrayList<b> ffV;
    private int ffX;
    private int ffY;
    private int ffZ;
    private int fga;
    private a fgm;
    private LinearLayout mContainer;
    private int mSkinType;

    /* loaded from: classes20.dex */
    public interface a {
        void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData);
    }

    public SignItemView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ffV = new ArrayList<>();
        this.ffZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fga = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    public SignItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ffV = new ArrayList<>();
        this.ffZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fga = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    public SignItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ffV = new ArrayList<>();
        this.ffZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds160);
        this.fga = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sign_dialog_cus_view, (ViewGroup) this, true);
        this.mContainer = (LinearLayout) findViewById(R.id.sign_item_container);
        this.ffU = (LineView) findViewById(R.id.line_view);
        this.ffX = l.getDimens(getContext(), R.dimen.tbds23);
        this.ffY = l.getDimens(getContext(), R.dimen.tbds26);
    }

    public void setItemClickListener(a aVar) {
        this.fgm = aVar;
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.ffU.onChangeSkinType();
            Iterator<b> it = this.ffV.iterator();
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
                this.ffV.clear();
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (size <= 3) {
                        marginLayoutParams.leftMargin = this.ffY;
                        marginLayoutParams.rightMargin = this.ffY;
                    } else {
                        marginLayoutParams.leftMargin = this.ffX;
                        marginLayoutParams.rightMargin = this.ffX;
                    }
                    setLayoutParams(marginLayoutParams);
                }
                if (this.ffU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ffU.getLayoutParams();
                    if (size <= 3) {
                        if (marginLayoutParams2.leftMargin != this.ffZ || marginLayoutParams2.rightMargin != this.ffZ) {
                            marginLayoutParams2.leftMargin = this.ffZ;
                            marginLayoutParams2.rightMargin = this.ffZ;
                            this.ffU.setLayoutParams(marginLayoutParams2);
                        }
                    } else if (marginLayoutParams2.leftMargin != this.fga || marginLayoutParams2.rightMargin != this.fga) {
                        marginLayoutParams2.leftMargin = this.fga;
                        marginLayoutParams2.rightMargin = this.fga;
                        this.ffU.setLayoutParams(marginLayoutParams2);
                    }
                }
                for (int i = 0; i < size; i++) {
                    this.ffV.add(c(arrayList.get(i)));
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
        bVar.fgi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.widget.mission.SignItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!bVar.fgk) {
                    Iterator it = SignItemView.this.ffV.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).jW(false);
                    }
                    bVar.jW(true);
                    if (SignItemView.this.fgm == null) {
                        return;
                    }
                    SignItemView.this.fgm.b(bVar.fgl);
                }
            }
        });
        return bVar;
    }

    /* loaded from: classes20.dex */
    public static class b {
        private int fgh;
        private ImageView fgi;
        private CircleView fgj;
        private ActiveCenterData.ActiveCenterStatusData fgl;
        private View itemView;
        private TextView textView;
        private int fgd = R.drawable.ic_pic_mask_task_complete_svg;
        private int fge = R.drawable.ic_pic_mask_task_select_svg;
        private int fgf = R.drawable.ic_pic_mask_task_comingsoon_svg;
        private int fgg = R.drawable.ic_pic_mask_task_uncomplete_svg;
        private boolean fgk = false;

        public b(View view, ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
            this.fgh = this.fgf;
            this.fgl = activeCenterStatusData;
            this.itemView = view;
            this.fgi = (ImageView) this.itemView.findViewById(R.id.item_icon);
            this.textView = (TextView) this.itemView.findViewById(R.id.item_text);
            this.fgj = (CircleView) this.itemView.findViewById(R.id.select_circle);
            this.fgj.setVisibility(4);
            if (activeCenterStatusData.is_today_mission == 0) {
                if (activeCenterStatusData.is_completed) {
                    this.fgh = this.fgd;
                } else {
                    this.fgh = this.fgg;
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.fgj.setVisibility(0);
                if (activeCenterStatusData.is_completed) {
                    this.fgh = this.fgd;
                } else {
                    this.fgh = this.fge;
                }
            } else {
                this.fgh = this.fgf;
            }
            SvgManager.bkl().a(this.fgi, this.fgh, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.cp_cont_d);
            this.textView.setText(activeCenterStatusData.day + "天");
        }

        public void onChangeSkinType() {
            SvgManager.bkl().a(this.fgi, this.fgh, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.textView, R.color.cp_cont_d);
            this.fgj.onChangeSkinType();
        }

        public void jW(boolean z) {
            if (z) {
                this.fgk = true;
                this.fgj.setVisibility(0);
                return;
            }
            this.fgk = false;
            this.fgj.setVisibility(4);
        }
    }
}
