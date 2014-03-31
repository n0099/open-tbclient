package com.baidu.tieba.im.groupCard;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.adp.a.f;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.im.h;
import com.baidu.tieba.im.i;
import com.baidu.tieba.im.j;
/* loaded from: classes.dex */
public final class d extends f {
    private View a;
    private GroupCardActivity c;
    private LinearLayout d;
    private LinearLayout e;
    private LinearLayout f;
    private View g;
    private ProgressBar h;
    private NavigationBar i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private ImageView n;

    public d(GroupCardActivity groupCardActivity) {
        super(groupCardActivity);
        this.a = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.c = groupCardActivity;
        this.c.setContentView(i.group_card_activity);
        this.a = this.c.findViewById(h.parent);
        this.d = (LinearLayout) this.c.findViewById(h.groud_card_save);
        this.d.setOnClickListener(this.c);
        this.e = (LinearLayout) this.c.findViewById(h.group_card_share);
        if (g.a(this.c)) {
            this.e.setOnClickListener(this.c);
        } else {
            this.e.setVisibility(8);
        }
        this.f = (LinearLayout) this.c.findViewById(h.group_card_setting);
        this.h = (ProgressBar) this.c.findViewById(h.progress);
        this.j = (ImageView) this.c.findViewById(h.group_card_inner_image);
        this.i = (NavigationBar) this.c.findViewById(h.group_card_topbar);
        this.i.setSystemClickable(false);
        this.i.a(this.c.getResources().getString(j.group_card_name));
        this.g = this.i.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.g.setOnClickListener(this.c);
    }

    public final void a(com.baidu.adp.widget.ImageView.b bVar) {
        if (bVar != null) {
            bVar.a(this.j);
        }
    }

    public final void a(int i, String str) {
        String str2;
        if (str != null) {
            com.baidu.adp.lib.util.i.a((Context) this.c, str);
            return;
        }
        boolean z = false;
        switch (z) {
            case true:
                str2 = "定位失败了，右上角点下刷新吧~";
                break;
            case true:
                str2 = "录音发生错误";
                break;
            case true:
            case true:
            case true:
            case true:
                str2 = "你的网络状况不大好，请稍后重试";
                break;
            case true:
                str2 = "未知错误";
                break;
            case true:
                str2 = "创建私聊不成功，请稍后再试";
                break;
            case true:
                str2 = "内容不合适，请修改下吧";
                break;
            case true:
                str2 = "内容不能为空，请修改下吧";
                break;
            case true:
                str2 = "最多允许20个表情，请修改下吧";
                break;
            case true:
                str2 = "发的太频繁啦";
                break;
            case true:
                str2 = "录音太短啦";
                break;
            case true:
                str2 = "操作违规";
                break;
            case true:
                str2 = "存储卡已满，请清理文件";
                break;
            case true:
                str2 = "存储卡读写失败";
                break;
            case true:
                str2 = "你的存储卡被USB占用，请更改数据线连接方式";
                break;
            case true:
                str2 = "无法找到存储卡";
                break;
            case true:
                str2 = "数据转换失败";
                break;
            case false:
                str2 = null;
                break;
            default:
                str2 = "未定义错误";
                break;
        }
        if (str2 != null && str2.length() > 0) {
            com.baidu.adp.lib.util.i.a((Context) this.c, str2);
        }
    }

    public final void a() {
        this.h.setVisibility(0);
    }

    public final void d() {
        this.h.setVisibility(8);
    }

    public final void e() {
        this.j.setVisibility(0);
    }

    public final View f() {
        return this.d;
    }

    public final View g() {
        return this.e;
    }

    public final View h() {
        return this.g;
    }

    public final View i() {
        return this.i;
    }

    public final LinearLayout j() {
        return this.f;
    }

    public final void a(int i) {
        this.c.getLayoutMode().a(i == 1);
        this.c.getLayoutMode().a(this.a);
        ba.a(this.a, i);
        this.i.b(i);
    }
}
