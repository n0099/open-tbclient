package com.baidu.tieba.flutter.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.animation.Animation;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.c;
/* loaded from: classes12.dex */
public class FlutterActivityPageContext<T> implements TbPageContext<T> {
    FlutterPageActivity<T> activity;

    public FlutterActivityPageContext(FlutterPageActivity<T> flutterPageActivity) {
        this.activity = flutterPageActivity;
    }

    @Override // com.baidu.adp.base.f
    public String getString(int i) {
        return getResources().getString(i);
    }

    @Override // com.baidu.adp.base.f
    public void sendMessage(Message<?> message) {
        this.activity.sendMessage(message);
    }

    @Override // com.baidu.adp.base.f
    public void sendMessage(NetMessage netMessage) {
        this.activity.sendMessage(netMessage);
    }

    @Override // com.baidu.adp.base.f
    public void registerListener(a aVar) {
        this.activity.registerListener(aVar);
    }

    public void registerListener(int i, a aVar) {
        this.activity.registerListener(i, aVar);
    }

    @Override // com.baidu.adp.base.f
    public void registerListener(MessageListener<?> messageListener) {
        this.activity.registerListener(messageListener);
    }

    @Override // com.baidu.adp.base.f
    public void registerListener(int i, MessageListener<?> messageListener) {
        this.activity.registerListener(i, messageListener);
    }

    @Override // com.baidu.adp.base.f
    public BdUniqueId getUniqueId() {
        return this.activity.getUniqueId();
    }

    @Override // com.baidu.adp.base.f
    public Context getContext() {
        return this.activity.getActivity();
    }

    @Override // com.baidu.adp.base.f
    public Activity getPageActivity() {
        return this.activity.getActivity();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.baidu.tieba.flutter.view.FlutterPageActivity<T>] */
    @Override // com.baidu.adp.base.f
    public T getOrignalPage() {
        return this.activity;
    }

    @Override // com.baidu.adp.base.f
    public Resources getResources() {
        return this.activity.getResources();
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i) {
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str, boolean z) {
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(int i, boolean z) {
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void showToast(String str) {
    }

    @Override // com.baidu.tbadk.TbPageContext
    public c getLayoutMode() {
        return this.activity.getLayoutMode();
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void startAnimatable(Animatable animatable) {
    }

    @Override // com.baidu.tbadk.TbPageContext
    public void startAnimation(View view, Animation animation, Animation.AnimationListener animationListener) {
    }
}
