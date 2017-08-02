package com.baidu.tieba.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.data.b;
/* loaded from: classes.dex */
public abstract class a<T extends com.baidu.tieba.card.data.b> implements View.OnClickListener {
    private String aia;
    protected x<T> bCu;
    protected w bEq;
    public Context mContext;
    public TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private BdUniqueId mTag = null;
    private View mView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null, false);

    public abstract void a(T t);

    public abstract void d(TbPageContext<?> tbPageContext, int i);

    public abstract int getLayout();

    public a(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
    }

    public BdUniqueId getTag() {
        return this.mTag;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public String getFrom() {
        return this.aia;
    }

    public void setFrom(String str) {
        this.aia = str;
    }

    public View getView() {
        return this.mView;
    }

    public Context getContext() {
        return this.mContext;
    }

    public TbPageContext<?> VY() {
        return this.mTbPageContext;
    }

    public void a(x<T> xVar) {
        this.bCu = xVar;
    }

    public void a(w wVar) {
        this.bEq = wVar;
    }

    public x<T> VZ() {
        return this.bCu;
    }
}
