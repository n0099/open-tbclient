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
    private String aiq;
    protected x<T> bJi;
    protected w bJj;
    public Context mContext;
    public int mSkinType;
    private BdUniqueId mTag;
    public TbPageContext<?> mTbPageContext;
    private View mView;

    public abstract void a(T t);

    public abstract void d(TbPageContext<?> tbPageContext, int i);

    public abstract int getLayout();

    public a(TbPageContext<?> tbPageContext) {
        this.mSkinType = 3;
        this.mTag = null;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null, false);
    }

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        this.mSkinType = 3;
        this.mTag = null;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mView = LayoutInflater.from(getContext()).inflate(getLayout(), viewGroup, false);
    }

    public BdUniqueId getTag() {
        return this.mTag;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }

    public String getFrom() {
        return this.aiq;
    }

    public void setFrom(String str) {
        this.aiq = str;
    }

    public View getView() {
        return this.mView;
    }

    public Context getContext() {
        return this.mContext;
    }

    public TbPageContext<?> Xq() {
        return this.mTbPageContext;
    }

    public void onDestroy() {
    }

    public void b(x<T> xVar) {
        this.bJi = xVar;
    }

    public void a(w wVar) {
        this.bJj = wVar;
    }

    public x<T> Xr() {
        return this.bJi;
    }
}
