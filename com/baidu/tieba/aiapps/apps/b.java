package com.baidu.tieba.aiapps.apps;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.lang.reflect.Field;
/* loaded from: classes4.dex */
public final class b {
    public static PopupWindow a(final com.baidu.tieba.aiapps.apps.abtest.msg.a aVar) {
        Activity fX = com.baidu.adp.base.a.fW().fX();
        if (fX == null || aVar == null) {
            return null;
        }
        final String url = aVar.getUrl();
        if (StringUtils.isNull(url)) {
            return null;
        }
        View inflate = LayoutInflater.from(fX).inflate(e.h.aiapps_token_layout, (ViewGroup) null, true);
        TextView textView = (TextView) inflate.findViewById(e.g.go_to_aiapps_go);
        TextView textView2 = (TextView) inflate.findViewById(e.g.go_to_aiapps_cancel);
        TextView textView3 = (TextView) inflate.findViewById(e.g.token_title);
        TextView textView4 = (TextView) inflate.findViewById(e.g.token_tip);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(e.g.token_top_cover);
        tbImageView.setDefaultResource(e.f.toastpic);
        tbImageView.setAutoChangeStyle(false);
        final PopupWindow popupWindow = new PopupWindow(fX);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == e.g.go_to_aiapps_go) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921361, url));
                    TiebaStatic.log(new am("c13274").ax("uid", TbadkCoreApplication.getCurrentAccount()).ax(VideoPlayActivityConfig.OBJ_ID, aVar.appId).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "tb_password"));
                    try {
                        popupWindow.dismiss();
                    } catch (Throwable th) {
                        BdLog.e(th);
                    }
                } else if (view.getId() == e.g.go_to_aiapps_cancel) {
                    try {
                        popupWindow.dismiss();
                    } catch (Throwable th2) {
                        BdLog.e(th2);
                    }
                }
            }
        };
        textView.setOnClickListener(onClickListener);
        textView2.setOnClickListener(onClickListener);
        if (!StringUtils.isNull(aVar.Wr())) {
            tbImageView.startLoad(aVar.Wr(), 10, false);
        } else {
            tbImageView.setImageResource(e.f.toastpic);
        }
        textView.setText(aVar.Ws());
        textView2.setText(aVar.Wt());
        textView3.setText(aVar.getTitle());
        textView4.setText(aVar.getTips());
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(Color.argb(178, 0, 0, 0));
        popupWindow.setBackgroundDrawable(colorDrawable);
        popupWindow.setWidth(l.aO(fX));
        popupWindow.setHeight(l.aQ(fX));
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
