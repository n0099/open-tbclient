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
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.BdToken.g;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.lang.reflect.Field;
/* loaded from: classes12.dex */
public final class a {
    public static PopupWindow a(final g gVar) {
        View.OnClickListener onClickListener;
        Activity currentActivity = com.baidu.adp.base.a.jm().currentActivity();
        if (currentActivity == null || gVar == null) {
            return null;
        }
        final String url = gVar.getUrl();
        if (StringUtils.isNull(url)) {
            return null;
        }
        View inflate = LayoutInflater.from(currentActivity).inflate(R.layout.aiapps_token_layout, (ViewGroup) null, true);
        TextView textView = (TextView) inflate.findViewById(R.id.go_to_aiapps_go);
        TextView textView2 = (TextView) inflate.findViewById(R.id.go_to_aiapps_cancel);
        TextView textView3 = (TextView) inflate.findViewById(R.id.token_title);
        TextView textView4 = (TextView) inflate.findViewById(R.id.token_tip);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.token_top_cover);
        tbImageView.setDefaultResource(R.drawable.toastpic);
        tbImageView.setAutoChangeStyle(false);
        final PopupWindow popupWindow = new PopupWindow(currentActivity);
        switch (gVar.aLA()) {
            case 3:
                tbImageView.setImageResource(R.drawable.toastpic_scheme);
                onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getId() == R.id.go_to_aiapps_go) {
                            if (com.baidu.adp.base.a.jm().currentActivity() != null && !StringUtils.isNull(g.this.getUrl())) {
                                Uri parse = Uri.parse(g.this.getUrl());
                                if (parse != null && parse.getQueryParameters("obj_type") != null && parse.getQueryParameters("obj_source") != null) {
                                    TiebaStatic.log(new an("c13391").dh("obj_type", parse.getQueryParameter("obj_type")).dh("obj_source", parse.getQueryParameter("obj_source")));
                                }
                                if (g.this.getUrl().startsWith(f.dvg)) {
                                    Uri.Builder buildUpon = Uri.parse(g.this.getUrl()).buildUpon();
                                    buildUpon.appendQueryParameter(f.dvz, f.dvJ);
                                    parse = buildUpon.build();
                                }
                                UtilHelper.dealOneScheme(com.baidu.adp.base.a.jm().currentActivity(), parse.toString());
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
                View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.a.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (view.getId() == R.id.go_to_aiapps_go) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, url));
                            TiebaStatic.log(new an("c13274").dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("obj_id", gVar.dvP).dh("obj_source", "tb_password").dh("obj_name", gVar.appName).ag("obj_param1", gVar.dvQ.intValue()));
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
                if (!StringUtils.isNull(gVar.getImg())) {
                    tbImageView.startLoad(gVar.getImg(), 10, false);
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
        textView.setText(gVar.aLy());
        textView2.setText(gVar.aLz());
        textView3.setText(gVar.getTitle());
        textView4.setText(gVar.getTips());
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(Color.argb((int) Opcodes.GETSTATIC, 0, 0, 0));
        popupWindow.setBackgroundDrawable(colorDrawable);
        popupWindow.setWidth(l.getEquipmentWidth(currentActivity));
        popupWindow.setHeight(l.getEquipmentHeight(currentActivity));
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
