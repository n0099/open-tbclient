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
    private String adE;
    private bz<T> bbu;
    protected by bbv;
    public Context mContext;
    public TbPageContext<?> mTbPageContext;
    public int mSkinType = 3;
    private BdUniqueId mTag = null;
    private View mView = LayoutInflater.from(getContext()).inflate(getLayout(), (ViewGroup) null, false);

    public abstract int getLayout();

    public abstract void onBindDataToView(T t);

    public abstract void onChangeSkinType(TbPageContext<?> tbPageContext, int i);

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
        return this.adE;
    }

    public void setFrom(String str) {
        this.adE = str;
    }

    public View getView() {
        return this.mView;
    }

    public Context getContext() {
        return this.mContext;
    }

    public TbPageContext<?> getTbPageContext() {
        return this.mTbPageContext;
    }

    public void onStart() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }

    public void setOnSubCardOnClickListenner(bz<T> bzVar) {
        this.bbu = bzVar;
    }

    public void setOnCardStatisticsCallback(by byVar) {
        this.bbv = byVar;
    }

    public bz<T> getOnSubCardOnClickListenner() {
        return this.bbu;
    }
}
