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
import com.baidu.tieba.R;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public final class d {
    public static PopupWindow a(final g gVar) {
        View.OnClickListener onClickListener;
        Activity eN = com.baidu.adp.base.a.eM().eN();
        if (eN == null || gVar == null) {
            return null;
        }
        final String url = gVar.getUrl();
        if (StringUtils.isNull(url)) {
            return null;
        }
        View inflate = LayoutInflater.from(eN).inflate(R.layout.aiapps_token_layout, (ViewGroup) null, true);
        TextView textView = (TextView) inflate.findViewById(R.id.go_to_aiapps_go);
        TextView textView2 = (TextView) inflate.findViewById(R.id.go_to_aiapps_cancel);
        TextView textView3 = (TextView) inflate.findViewById(R.id.token_title);
        TextView textView4 = (TextView) inflate.findViewById(R.id.token_tip);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.token_top_cover);
        tbImageView.setDefaultResource(R.drawable.toastpic);
        tbImageView.setAutoChangeStyle(false);
        final PopupWindow popupWindow = new PopupWindow(eN);
        switch (gVar.YF()) {
            case 3:
                tbImageView.setImageResource(R.drawable.toastpic_scheme);
                onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getId() == R.id.go_to_aiapps_go) {
                            if (com.baidu.adp.base.a.eM().eN() != null && !StringUtils.isNull(g.this.getUrl())) {
                                Uri parse = Uri.parse(g.this.getUrl());
                                if (parse != null && parse.getQueryParameters("obj_type") != null && parse.getQueryParameters(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE) != null) {
                                    TiebaStatic.log(new am("c13391").bT("obj_type", parse.getQueryParameter("obj_type")).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, parse.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE)));
                                }
                                if (g.this.getUrl().startsWith(f.SCHEME)) {
                                    Uri.Builder buildUpon = Uri.parse(g.this.getUrl()).buildUpon();
                                    buildUpon.appendQueryParameter(f.byu, f.byx);
                                    parse = buildUpon.build();
                                }
                                UtilHelper.dealOneScheme(com.baidu.adp.base.a.eM().eN(), parse.toString());
                            }
                            try {
                                popupWindow.dismiss();
                            } catch (Throwable th) {
                                BdLog.e(th);
                            }
                        } else if (view.getId() == R.id.go_to_aiapps_cancel) {
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
                        if (view.getId() == R.id.go_to_aiapps_go) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, url));
                            TiebaStatic.log(new am("c13274").bT("uid", TbadkCoreApplication.getCurrentAccount()).bT(VideoPlayActivityConfig.OBJ_ID, gVar.byD).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "tb_password").bT("obj_name", gVar.appName).P("obj_param1", gVar.byE.intValue()));
                            try {
                                popupWindow.dismiss();
                            } catch (Throwable th) {
                                BdLog.e(th);
                            }
                        } else if (view.getId() == R.id.go_to_aiapps_cancel) {
                            try {
                                popupWindow.dismiss();
                            } catch (Throwable th2) {
                                BdLog.e(th2);
                            }
                        }
                    }
                };
                if (!StringUtils.isNull(gVar.YC())) {
                    tbImageView.startLoad(gVar.YC(), 10, false);
                    onClickListener = onClickListener2;
                    break;
                } else {
                    tbImageView.setImageResource(R.drawable.toastpic);
                    onClickListener = onClickListener2;
                    break;
                }
        }
        textView.setOnClickListener(onClickListener);
        textView2.setOnClickListener(onClickListener);
        textView.setText(gVar.YD());
        textView2.setText(gVar.YE());
        textView3.setText(gVar.getTitle());
        textView4.setText(gVar.getTips());
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(Color.argb(178, 0, 0, 0));
        popupWindow.setBackgroundDrawable(colorDrawable);
        popupWindow.setWidth(l.af(eN));
        popupWindow.setHeight(l.ah(eN));
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
