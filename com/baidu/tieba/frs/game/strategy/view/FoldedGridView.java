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
    private static final int hla = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private View hlb;
    private int hlc;
    private int hld;
    private boolean hle;
    private com.baidu.tieba.frs.game.strategy.view.a hlf;
    private a hlg;
    private int hlh;
    private Drawable hli;

    /* loaded from: classes9.dex */
    public interface a {
        void i(int i, Object obj);
    }

    public FoldedGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hlc = 0;
        this.hld = 0;
        this.hle = true;
        this.hlh = 0;
        init();
    }

    public FoldedGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hlc = 0;
        this.hld = 0;
        this.hle = true;
        this.hlh = 0;
        init();
    }

    public FoldedGridView(Context context) {
        super(context);
        this.hlc = 0;
        this.hld = 0;
        this.hle = true;
        this.hlh = 0;
        init();
    }

    private void init() {
        setSelector(new ColorDrawable(0));
        setOnItemClickListener(this);
    }

    public void onChangeSkinType(int i) {
        if (this.hlb != null) {
            bZ(this.hlb);
        }
        if (this.hlh != 0) {
            this.hli = am.getDrawable(i, this.hlh);
        }
    }

    public void setArrowResouceId(int i, int i2) {
        this.hlc = i;
        this.hld = i2;
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setExpandedBottomShadeResourceId(int i) {
        this.hlh = i;
        if (this.hlh == 0) {
            this.hli = am.getDrawable(i);
        } else {
            this.hli = null;
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public View getArrowView() {
        if (this.hlb == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            ImageView imageView = new ImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            frameLayout.addView(imageView, layoutParams);
            this.hlb = frameLayout;
        }
        return this.hlb;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public void bZ(View view) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getChildCount() > 0 && (frameLayout.getChildAt(0) instanceof ImageView)) {
                ImageView imageView = (ImageView) frameLayout.getChildAt(0);
                if (this.hle) {
                    imageView.setImageDrawable(am.getDrawable(this.hlc));
                } else {
                    imageView.setImageDrawable(am.getDrawable(this.hld));
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public boolean bSs() {
        return getNumColumns() > 0;
    }

    @Override // com.baidu.tieba.frs.game.strategy.view.f
    public int getArrowIndex() {
        if (bSs()) {
            return getNumColumns() - 1;
        }
        return -1;
    }

    public void setFoldAdapter(com.baidu.tieba.frs.game.strategy.view.a aVar) {
        this.hlf = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
        setAdapter((ListAdapter) aVar);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view == this.hlb) {
            if (this.hlf != null && this.hlf.bSu()) {
                bSt();
            }
        } else if (this.hlg != null && this.hlf != null) {
            int uc = this.hlf.uc(i);
            this.hlf.ub(uc);
            this.hlg.i(uc, this.hlf.getItem(i));
        }
    }

    private void bSt() {
        this.hle = !this.hle;
        bZ(this.hlb);
        if (this.hlf != null) {
            this.hlf.mZ(this.hle);
            this.hlf.notifyDataSetChanged();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.BdGridView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int height = getHeight();
        if (!this.hle && this.hli != null) {
            this.hli.setBounds(0, (height - hla) - getPaddingBottom(), getWidth(), height - getPaddingBottom());
            this.hli.draw(canvas);
        }
    }

    public void setFoldGridViewOnItemClickListener(a aVar) {
        this.hlg = aVar;
    }
}
