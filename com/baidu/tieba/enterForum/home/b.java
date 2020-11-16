package com.baidu.tieba.enterForum.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.view.a;
import com.baidu.tieba.enterForum.view.f;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class b {
    private f iiC;
    private com.baidu.tieba.enterForum.view.a ikS;
    private a ikT;
    private Context mContext;
    private int mSortType;
    private int mStatusBarHeight;
    private TextView mTitle;
    private boolean ikU = false;
    private a.InterfaceC0719a ikV = new a.InterfaceC0719a() { // from class: com.baidu.tieba.enterForum.home.b.1
        @Override // com.baidu.tieba.enterForum.view.a.InterfaceC0719a
        public void onItemClick(int i) {
            b.this.mSortType = i;
            TiebaStatic.log(new ar("c13369").ak("obj_type", i == 1 ? 2 : 1));
            b.this.crG();
            if (b.this.ikT != null) {
                b.this.ikT.yc(b.this.mSortType);
            }
        }
    };
    private View.OnClickListener eTp = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.home.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.iiC.cti()) {
                if (view == b.this.mTitle) {
                    if (b.this.ikS == null) {
                        b.this.ikS = new com.baidu.tieba.enterForum.view.a(b.this.mContext);
                        b.this.ikS.setOnDismissListener(b.this.mOnDismissListener);
                        b.this.ikS.a(b.this.ikV);
                        b.this.ikS.yv(b.this.mStatusBarHeight);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new h(b.this.mContext.getString(R.string.level_sort), 1));
                    arrayList.add(new h(b.this.mContext.getString(R.string.update_sort), 2));
                    b.this.ikS.setData(arrayList, b.this.mSortType);
                    b.this.ikS.O(b.this.mTitle);
                }
                b.this.ikU = true;
                b.this.oS(b.this.ikU);
            }
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.enterForum.home.b.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.ikU = false;
            b.this.oS(b.this.ikU);
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void yc(int i);
    }

    public b(Context context, int i, int i2, f fVar) {
        this.mContext = context;
        this.mSortType = i;
        this.mStatusBarHeight = i2;
        this.iiC = fVar;
    }

    public void k(TextView textView) {
        this.mTitle = textView;
    }

    public void TD() {
        if (this.ikS != null) {
            this.ikS.TD();
        }
    }

    public void crG() {
        if (crH() && this.mTitle != null) {
            switch (this.mSortType) {
                case 1:
                    this.mTitle.setText(R.string.level_sort);
                    break;
                case 2:
                    this.mTitle.setText(R.string.update_sort);
                    break;
            }
            this.mTitle.setOnClickListener(this.eTp);
            oS(this.ikU);
        }
    }

    public boolean crH() {
        return this.mSortType == 1 || this.mSortType == 2;
    }

    public void setSortType(int i) {
        if (crH()) {
            this.mSortType = i;
            crG();
        }
    }

    public void a(a aVar) {
        this.ikT = aVar;
    }

    public void onChangeSkinType(int i) {
        if (crH()) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105, i);
            if (this.mTitle != null) {
                oS(this.ikU);
            }
        }
        if (this.ikS != null && this.ikU) {
            this.ikS.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oS(boolean z) {
        int i = z ? R.drawable.icon_pure_fold12_svg : R.drawable.icon_pure_unfold12_svg;
        com.baidu.tieba.enterForum.data.c cto = this.iiC != null ? this.iiC.cto() : null;
        if (cto != null && cto.iji) {
            if (this.iiC != null && this.iiC.isShow()) {
                ap.setViewTextColor(this.mTitle, R.color.CAM_X0107);
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bqB().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
                return;
            }
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0107);
            this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bqB().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
            return;
        }
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0107);
        this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.bqB().a(i, R.color.CAM_X0108, (SvgManager.SvgResourceStateType) null), (Drawable) null);
    }
}
