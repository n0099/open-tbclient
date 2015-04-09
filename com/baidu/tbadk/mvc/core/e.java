package com.baidu.tbadk.mvc.core;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.mvc.core.a;
import com.baidu.tbadk.mvc.core.c;
/* loaded from: classes.dex */
public interface e<V extends c, M extends a, T> extends View.OnClickListener, TbPageContextSupport<T> {
    LayoutInflater getLayoutInflater();

    com.baidu.tbadk.core.c getLayoutMode();

    Resources getResources();

    BdUniqueId getUniqueId();

    M oi();

    V ok();

    void showLoadingView(View view);

    ViewEventCenter zZ();
}
