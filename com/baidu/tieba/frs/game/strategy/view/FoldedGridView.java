package com.baidu.tieba.frs.game.strategy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int dLZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds48);
    private View dMa;
    private int dMb;
    private int dMc;
    private boolean dMd;
    private com.baidu.tieba.frs.game.strategy.view.a dMe;
    private a dMf;
    private int dMg;
    private Drawable dMh;

    /* loaded from: classes3.dex */
    public interface a {
        void c(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dMb = 0;
        this.dMc = 0;
        this.dMd = true;
        this.dMg = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dMb = 0;
        this.dMc = 0;
        this.dMd = true;
        this.dMg = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.dMb = 0;
        this.dMc = 0;
        this.dMd = true;
        this.dMg = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.dMa != null) {
            aM(this.dMa);
        }
        if (this.dMg != 0) {
            this.dMh = al.x(i, this.dMg);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.dMb = i;
        this.dMc = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.dMg = i;
        if (this.dMg == 0) {
            this.dMh = al.getDrawable(i);
        } else {
            this.dMh = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.dMa == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.dMa = frameLayout;
        }
        return this.dMa;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void aM(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.dMd) {
                    imageView.setImageDrawable(al.getDrawable(this.dMb));
                } else {
                    imageView.setImageDrawable(al.getDrawable(this.dMc));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean aDx() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (aDx()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.dMe = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.dMa) {
            if (this.dMe != null && this.dMe.aDz()) {
                aDy();
            }
        } else if (this.dMf != null && this.dMe != null) {
            int mf = this.dMe.mf(i);
            this.dMe.me(mf);
            this.dMf.c(mf, this.dMe.getItem(i));
        }
    }

    private void aDy() {
        this.dMd = !this.dMd;
        aM(this.dMa);
        if (this.dMe != null) {
            this.dMe.gS(this.dMd);
            this.dMe.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.dMd && this.dMh != null) {
            this.dMh.setBounds(0, (height - dLZ) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.dMh.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.dMf = aVar;
    }
}
