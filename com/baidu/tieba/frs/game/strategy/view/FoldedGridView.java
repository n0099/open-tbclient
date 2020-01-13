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
/* loaded from: classes7.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int gys = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private Drawable gyA;
    private View gyt;
    private int gyu;
    private int gyv;
    private boolean gyw;
    private com.baidu.tieba.frs.game.strategy.view.a gyx;
    private a gyy;
    private int gyz;

    /* loaded from: classes7.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gyu = 0;
        this.gyv = 0;
        this.gyw = true;
        this.gyz = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gyu = 0;
        this.gyv = 0;
        this.gyw = true;
        this.gyz = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.gyu = 0;
        this.gyv = 0;
        this.gyw = true;
        this.gyz = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.gyt != null) {
            bR(this.gyt);
        }
        if (this.gyz != 0) {
            this.gyA = am.getDrawable(i, this.gyz);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.gyu = i;
        this.gyv = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.gyz = i;
        if (this.gyz == 0) {
            this.gyA = am.getDrawable(i);
        } else {
            this.gyA = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.gyt == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.gyt = frameLayout;
        }
        return this.gyt;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bR(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.gyw) {
                    imageView.setImageDrawable(am.getDrawable(this.gyu));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.gyv));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bGc() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bGc()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.gyx = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.gyt) {
            if (this.gyx != null && this.gyx.bGe()) {
                bGd();
            }
        } else if (this.gyy != null && this.gyx != null) {
            int ts = this.gyx.ts(i);
            this.gyx.tr(ts);
            this.gyy.i(ts, this.gyx.getItem(i));
        }
    }

    private void bGd() {
        this.gyw = !this.gyw;
        bR(this.gyt);
        if (this.gyx != null) {
            this.gyx.lN(this.gyw);
            this.gyx.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.gyw && this.gyA != null) {
            this.gyA.setBounds(0, (height - gys) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.gyA.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.gyy = aVar;
    }
}
