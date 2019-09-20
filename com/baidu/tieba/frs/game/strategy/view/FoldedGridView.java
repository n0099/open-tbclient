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
/* loaded from: classes4.dex */
public class FoldedGridView extends BdGridView implements AdapterView.OnItemClickListener, f {
    private static final int fIp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View fIq;
    private int fIr;
    private int fIs;
    private boolean fIt;
    private com.baidu.tieba.frs.game.strategy.view.a fIu;
    private a fIv;
    private int fIw;
    private Drawable fIx;

    /* loaded from: classes4.dex */
    public interface a {
        void f(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fIr = 0;
        this.fIs = 0;
        this.fIt = true;
        this.fIw = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fIr = 0;
        this.fIs = 0;
        this.fIt = true;
        this.fIw = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.fIr = 0;
        this.fIs = 0;
        this.fIt = true;
        this.fIw = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.fIq != null) {
            bU(this.fIq);
        }
        if (this.fIw != 0) {
            this.fIx = am.V(i, this.fIw);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.fIr = i;
        this.fIs = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.fIw = i;
        if (this.fIw == 0) {
            this.fIx = am.getDrawable(i);
        } else {
            this.fIx = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.fIq == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.fIq = frameLayout;
        }
        return this.fIq;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bU(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.fIt) {
                    imageView.setImageDrawable(am.getDrawable(this.fIr));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.fIs));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bqA() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bqA()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.fIu = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.fIq) {
            if (this.fIu != null && this.fIu.bqC()) {
                bqB();
            }
        } else if (this.fIv != null && this.fIu != null) {
            int sp = this.fIu.sp(i);
            this.fIu.so(sp);
            this.fIv.f(sp, this.fIu.getItem(i));
        }
    }

    private void bqB() {
        this.fIt = !this.fIt;
        bU(this.fIq);
        if (this.fIu != null) {
            this.fIu.kD(this.fIt);
            this.fIu.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.fIt && this.fIx != null) {
            this.fIx.setBounds(0, (height - fIp) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.fIx.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.fIv = aVar;
    }
}
