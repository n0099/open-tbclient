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
    private static final int gAs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private Drawable gAA;
    private View gAt;
    private int gAu;
    private int gAv;
    private boolean gAw;
    private com.baidu.tieba.frs.game.strategy.view.a gAx;
    private a gAy;
    private int gAz;

    /* loaded from: classes9.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gAu = 0;
        this.gAv = 0;
        this.gAw = true;
        this.gAz = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gAu = 0;
        this.gAv = 0;
        this.gAw = true;
        this.gAz = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.gAu = 0;
        this.gAv = 0;
        this.gAw = true;
        this.gAz = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.gAt != null) {
            bR(this.gAt);
        }
        if (this.gAz != 0) {
            this.gAA = am.getDrawable(i, this.gAz);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.gAu = i;
        this.gAv = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.gAz = i;
        if (this.gAz == 0) {
            this.gAA = am.getDrawable(i);
        } else {
            this.gAA = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.gAt == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.gAt = frameLayout;
        }
        return this.gAt;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bR(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.gAw) {
                    imageView.setImageDrawable(am.getDrawable(this.gAu));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.gAv));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bHE() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bHE()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.gAx = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.gAt) {
            if (this.gAx != null && this.gAx.bHG()) {
                bHF();
            }
        } else if (this.gAy != null && this.gAx != null) {
            int ty = this.gAx.ty(i);
            this.gAx.tx(ty);
            this.gAy.i(ty, this.gAx.getItem(i));
        }
    }

    private void bHF() {
        this.gAw = !this.gAw;
        bR(this.gAt);
        if (this.gAx != null) {
            this.gAx.lQ(this.gAw);
            this.gAx.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.gAw && this.gAA != null) {
            this.gAA.setBounds(0, (height - gAs) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.gAA.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.gAy = aVar;
    }
}
