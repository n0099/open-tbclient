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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int hlg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View hlh;
    private int hli;
    private int hlj;
    private boolean hlk;
    private com.baidu.tieba.frs.game.strategy.view.a hll;
    private a hlm;
    private int hln;
    private Drawable hlo;

    /* loaded from: classes9.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hli = 0;
        this.hlj = 0;
        this.hlk = true;
        this.hln = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hli = 0;
        this.hlj = 0;
        this.hlk = true;
        this.hln = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.hli = 0;
        this.hlj = 0;
        this.hlk = true;
        this.hln = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.hlh != null) {
            bZ(this.hlh);
        }
        if (this.hln != 0) {
            this.hlo = am.getDrawable(i, this.hln);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.hli = i;
        this.hlj = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.hln = i;
        if (this.hln == 0) {
            this.hlo = am.getDrawable(i);
        } else {
            this.hlo = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.hlh == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.hlh = frameLayout;
        }
        return this.hlh;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bZ(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.hlk) {
                    imageView.setImageDrawable(am.getDrawable(this.hli));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.hlj));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bSr() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bSr()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.hll = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.hlh) {
            if (this.hll != null && this.hll.bSt()) {
                bSs();
            }
        } else if (this.hlm != null && this.hll != null) {
            int uc = this.hll.uc(i);
            this.hll.ub(uc);
            this.hlm.i(uc, this.hll.getItem(i));
        }
    }

    private void bSs() {
        this.hlk = !this.hlk;
        bZ(this.hlh);
        if (this.hll != null) {
            this.hll.mZ(this.hlk);
            this.hll.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.hlk && this.hlo != null) {
            this.hlo.setBounds(0, (height - hlg) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.hlo.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.hlm = aVar;
    }
}
