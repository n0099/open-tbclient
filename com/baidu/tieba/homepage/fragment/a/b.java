package com.baidu.tieba.homepage.fragment.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.base.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.homepage.fragment.data.e;
import com.baidu.tieba.homepage.listview.card.b.b;
import com.baidu.tieba.homepage.listview.card.c.d;
import com.baidu.tieba.homepage.listview.card.discover.h;
import com.baidu.tieba.homepage.listview.card.e.b;
import com.baidu.tieba.homepage.listview.card.f.b;
import com.baidu.tieba.homepage.listview.card.g.b;
import com.baidu.tieba.homepage.listview.card.h.b;
import com.baidu.tieba.homepage.listview.card.i.b;
import com.baidu.tieba.homepage.listview.g;
import com.baidu.tieba.n;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    public static View a(Context context, Class cls) {
        if (e.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.home_page_list_view_common_item_shell, (ViewGroup) null, false);
        }
        if (b.a.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.card_hot_twzb_banner, (ViewGroup) null, false);
        }
        if (b.C0065b.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.card_hot_twzb_thread_item, (ViewGroup) null, false);
        }
        if (com.baidu.tieba.homepage.listview.card.g.b.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.card_hot_topic_banner, (ViewGroup) null, false);
        }
        if (d.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.hot_activity_card_layout, (ViewGroup) null, false);
        }
        if (b.C0064b.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.card_hot_topic_item, (ViewGroup) null, false);
        }
        if (com.baidu.tieba.homepage.listview.a.b.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.sudoku_stytle, (ViewGroup) null, false);
        }
        if (com.baidu.tieba.homepage.listview.card.b.b.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.card_fun_center_item, (ViewGroup) null, false);
        }
        if (b.a.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.card_fun_cetner_game_layout, (ViewGroup) null, false);
        }
        if (com.baidu.tieba.homepage.listview.card.f.b.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.card_hot_thread, (ViewGroup) null, false);
        }
        if (b.a.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.card_hot_thread_item, (ViewGroup) null, false);
        }
        if (h.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.card_discover, (ViewGroup) null, false);
        }
        if (h.a.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.card_discover_item, (ViewGroup) null, false);
        }
        if (h.b.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.card_discover_item_cell, (ViewGroup) null, false);
        }
        if (com.baidu.tieba.homepage.listview.card.j.b.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.card_vip_center_item, (ViewGroup) null, false);
        }
        if (com.baidu.tieba.homepage.listview.card.d.b.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.card_hot_forum_item, (ViewGroup) null, false);
        }
        if (com.baidu.tieba.homepage.listview.card.e.b.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.card_hot_god, (ViewGroup) null, false);
        }
        if (b.a.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.card_hot_god_item, (ViewGroup) null, false);
        }
        if (com.baidu.tieba.homepage.listview.card.i.b.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.card_hot_video_layout, (ViewGroup) null, false);
        }
        if (b.a.class.equals(cls)) {
            return LayoutInflater.from(context).inflate(n.g.card_hot_video_layout_item, (ViewGroup) null, false);
        }
        return null;
    }

    public static ViewGroup h(Context context, View view) {
        if (view != null) {
            View a = a(context, e.class);
            if (a instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) a;
                if (viewGroup.getChildCount() > 1) {
                    viewGroup.addView(view, 2);
                    return viewGroup;
                }
            }
        }
        return null;
    }

    public static <V extends g<T>, T> ViewGroup a(Context context, ViewGroup viewGroup, List<T> list, Class<T> cls, List<V> list2, Class<V> cls2) {
        V v;
        if (viewGroup == null) {
            return null;
        }
        int k = y.k(list2);
        int k2 = y.k(list);
        if (k > k2) {
            for (int i = 0; i < k - k2; i++) {
                V v2 = list2.get(0);
                if (v2 != null) {
                    viewGroup.removeView(v2.TY());
                }
                list2.remove(v2);
            }
        }
        if (k2 != 0) {
            int i2 = 0;
            Constructor<V> constructor = null;
            while (i2 < list.size()) {
                T t = list.get(i2);
                g gVar = (g) y.b(list2, i2);
                if (gVar != null) {
                    gVar.D(t);
                } else {
                    View a = a(context, cls);
                    if (a == null) {
                        try {
                            throw new Exception(String.valueOf(cls.getName()) + " cannot create view!");
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (constructor == null) {
                        try {
                            constructor = cls2.getConstructor(TbPageContext.class, View.class);
                        } catch (NoSuchMethodException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (constructor == null) {
                        try {
                            throw new Exception(String.valueOf(cls2.getName()) + " cannot get holder construct!");
                            break;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    try {
                        v = constructor.newInstance(l.C(context), a);
                    } catch (IllegalAccessException e4) {
                        e4.printStackTrace();
                        v = null;
                    } catch (IllegalArgumentException e5) {
                        e5.printStackTrace();
                        v = null;
                    } catch (InstantiationException e6) {
                        e6.printStackTrace();
                        v = null;
                    } catch (InvocationTargetException e7) {
                        e7.printStackTrace();
                        v = null;
                    }
                    if (v == null) {
                        try {
                            throw new Exception(String.valueOf(cls2.getName()) + " cannot instance holder!");
                            break;
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                    }
                    v.D(t);
                    viewGroup.addView(v.TY());
                    list2.add(v);
                }
                i2++;
                constructor = constructor;
            }
            return viewGroup;
        }
        return null;
    }
}
