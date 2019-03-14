package com.baidu.tieba.aiapps.apps;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.BdToken.g;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public final class d {
    public static PopupWindow a(final g gVar) {
        View.OnClickListener onClickListener;
        Activity fU = com.baidu.adp.base.a.fT().fU();
        if (fU == null || gVar == null) {
            return null;
        }
        final String url = gVar.getUrl();
        if (StringUtils.isNull(url)) {
            return null;
        }
        View inflate = LayoutInflater.from(fU).inflate(d.h.aiapps_token_layout, (ViewGroup) null, true);
        TextView textView = (TextView) inflate.findViewById(d.g.go_to_aiapps_go);
        TextView textView2 = (TextView) inflate.findViewById(d.g.go_to_aiapps_cancel);
        TextView textView3 = (TextView) inflate.findViewById(d.g.token_title);
        TextView textView4 = (TextView) inflate.findViewById(d.g.token_tip);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.token_top_cover);
        tbImageView.setDefaultResource(d.f.toastpic);
        tbImageView.setAutoChangeStyle(false);
        final PopupWindow popupWindow = new PopupWindow(fU);
        switch (gVar.Up()) {
            case 3:
                tbImageView.setImageResource(d.f.toastpic_scheme);
                onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getId() == d.g.go_to_aiapps_go) {
                            if (com.baidu.adp.base.a.fT().fU() != null && !StringUtils.isNull(g.this.getUrl())) {
                                Uri parse = Uri.parse(g.this.getUrl());
                                if (parse != null && parse.getQueryParameters("obj_type") != null && parse.getQueryParameters(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE) != null) {
                                    TiebaStatic.log(new am("c13391").bJ("obj_type", parse.getQueryParameter("obj_type")).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, parse.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE)));
                                }
                                if (g.this.getUrl().startsWith(f.SCHEME)) {
                                    Uri.Builder buildUpon = Uri.parse(g.this.getUrl()).buildUpon();
                                    buildUpon.appendQueryParameter(f.brK, f.brN);
                                    parse = buildUpon.build();
                                }
                                UtilHelper.dealOneScheme(com.baidu.adp.base.a.fT().fU(), parse.toString());
                            }
                            try {
                                popupWindow.dismiss();
                            } catch (Throwable th) {
                                BdLog.e(th);
                            }
                        } else if (view.getId() == d.g.go_to_aiapps_cancel) {
                            try {
                                popupWindow.dismiss();
                            } catch (Throwable th2) {
                                BdLog.e(th2);
                            }
                        }
                    }
                };
                break;
            default:
                View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.d.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getId() == d.g.go_to_aiapps_go) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, url));
                            TiebaStatic.log(new am("c13274").bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(VideoPlayActivityConfig.OBJ_ID, gVar.appId).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "tb_password").bJ("obj_name", gVar.appName));
                            try {
                                popupWindow.dismiss();
                            } catch (Throwable th) {
                                BdLog.e(th);
                            }
                        } else if (view.getId() == d.g.go_to_aiapps_cancel) {
                            try {
                                popupWindow.dismiss();
                            } catch (Throwable th2) {
                                BdLog.e(th2);
                            }
                        }
                    }
                };
                if (!StringUtils.isNull(gVar.Um())) {
                    tbImageView.startLoad(gVar.Um(), 10, false);
                    onClickListener = onClickListener2;
                    break;
                } else {
                    tbImageView.setImageResource(d.f.toastpic);
                    onClickListener = onClickListener2;
                    break;
                }
        }
        textView.setOnClickListener(onClickListener);
        textView2.setOnClickListener(onClickListener);
        textView.setText(gVar.Un());
        textView2.setText(gVar.Uo());
        textView3.setText(gVar.getTitle());
        textView4.setText(gVar.getTips());
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(Color.argb(178, 0, 0, 0));
        popupWindow.setBackgroundDrawable(colorDrawable);
        popupWindow.setWidth(l.aO(fU));
        popupWindow.setHeight(l.aQ(fU));
        popupWindow.setContentView(inflate);
        popupWindow.setOutsideTouchable(true);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mLayoutInScreen");
                declaredField.setAccessible(true);
                declaredField.set(popupWindow, true);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
        }
        return popupWindow;
    }
}
