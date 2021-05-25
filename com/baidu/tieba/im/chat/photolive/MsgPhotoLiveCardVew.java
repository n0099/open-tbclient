package com.baidu.tieba.im.chat.photolive;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import d.a.c.e.p.l;
import d.a.n0.e3.n0.c;
import d.a.n0.f1.f.e;
import d.a.n0.f1.f.k.a;
import java.net.URLDecoder;
/* loaded from: classes4.dex */
public class MsgPhotoLiveCardVew extends e {
    public TextView A;
    public TextView B;
    public TextView C;
    public LinearLayout D;
    public TextView E;
    public int F;
    public long t;
    public long u;
    public int v;
    public LinearLayout w;
    public ClickableHeaderImageView x;
    public TextView y;
    public TextView z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MsgPhotoLiveCardVew.this.t > 0) {
                c photoLiveReadThreadHistory = TbadkCoreApplication.getInst().getPhotoLiveReadThreadHistory();
                if (MsgPhotoLiveCardVew.this.v != 1) {
                    if (MsgPhotoLiveCardVew.this.v != 3) {
                        if (MsgPhotoLiveCardVew.this.v != 4) {
                            if (MsgPhotoLiveCardVew.this.v == 5) {
                                TiebaStatic.log(TbadkCoreStatisticKey.CHANDE_OLD_SUCCESS);
                            }
                        } else {
                            TiebaStatic.log(TbadkCoreStatisticKey.UPGRADE_SUCCESS);
                        }
                    } else {
                        TiebaStatic.log(TbadkCoreStatisticKey.FANS_REMIND_CLICK);
                    }
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.PHOTO_LIVE_GREATCALL_MSG);
                    if (photoLiveReadThreadHistory != null && photoLiveReadThreadHistory.f(String.valueOf(MsgPhotoLiveCardVew.this.t)) > 0) {
                        MsgPhotoLiveCardVew msgPhotoLiveCardVew = MsgPhotoLiveCardVew.this;
                        msgPhotoLiveCardVew.u = photoLiveReadThreadHistory.f(String.valueOf(msgPhotoLiveCardVew.t));
                    }
                }
                MsgPhotoLiveCardVew msgPhotoLiveCardVew2 = MsgPhotoLiveCardVew.this;
                msgPhotoLiveCardVew2.N(msgPhotoLiveCardVew2.v);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MsgPhotoLiveCardVew.this.L(view);
        }
    }

    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_photolive_card_view);
        this.t = 0L;
        this.v = 0;
        this.F = 0;
        this.F = l.g(tbPageContext.getContext(), R.dimen.ds24);
        O();
    }

    public final SpannableStringBuilder J(String str, int i2) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i2));
        int K = K(i2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), indexOf, K + indexOf, 33);
        return spannableStringBuilder;
    }

    public final int K(int i2) {
        int i3 = 0;
        do {
            i2 /= 10;
            i3++;
        } while (i2 != 0);
        return i3;
    }

    public final void L(View view) {
        Object tag = view.getTag();
        if (tag instanceof String) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
        }
    }

    public final void N(int i2) {
        if (i2 == 5 || i2 == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.t), null, "message_tab")));
        }
    }

    public final void O() {
        this.w = (LinearLayout) d(R.id.msg_photolive_card);
        this.x = (ClickableHeaderImageView) d(R.id.author_portrait);
        this.y = (TextView) d(R.id.author_name);
        this.z = (TextView) d(R.id.call_time);
        this.A = (TextView) d(R.id.call_content);
        this.B = (TextView) d(R.id.call_thread_title);
        this.D = (LinearLayout) d(R.id.auhtor_name_and_call_time);
        this.C = (TextView) d(R.id.remind_title);
        this.E = (TextView) d(R.id.card_bottom_chakanzhibo);
        this.w.setOnClickListener(new a());
    }

    public void P(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        String decode;
        int i2;
        if (chatMessage == null) {
            return;
        }
        a.C1310a a2 = d.a.n0.f1.f.k.a.a(chatMessage.getContent());
        if (a2 == null) {
            this.t = 0L;
            return;
        }
        this.t = a2.f54447f;
        long j = a2.f54449h;
        this.v = a2.f54450i;
        int i3 = a2.j;
        ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        int i4 = this.v;
        int i5 = -1;
        if (i4 == 1 || i4 == 6) {
            if (this.v == 1) {
                decode = a2.f54448g;
                i2 = R.string.look_live_thread;
            } else {
                decode = URLDecoder.decode(a2.f54448g);
                i2 = R.string.look_god_thread;
                i5 = 0;
            }
            this.B.setText(decode);
            layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds72);
            this.D.setPadding(this.F, 0, 0, 0);
            this.x.setVisibility(0);
            this.x.setOnClickListener(new b());
            this.x.setTag(a2.f54443b);
            this.x.setGodIconMargin(i5);
            this.C.setVisibility(8);
            this.y.setVisibility(0);
            this.y.setText(a2.f54444c);
            this.A.setText(a2.f54446e);
            this.y.setTextSize(0, l.g(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
            this.E.setText(i2);
        } else if (i4 == 3) {
            this.B.setText(a2.f54448g);
            layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds80);
            this.D.setPadding(0, 0, 0, 0);
            this.x.setVisibility(8);
            this.C.setVisibility(0);
            this.y.setVisibility(8);
            this.C.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
            String str = a2.f54446e;
            if (str != null && str.indexOf(String.valueOf(i3)) != -1) {
                this.A.setText(J(a2.f54446e, i3));
            } else {
                this.A.setText(a2.f54446e);
            }
        } else {
            layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds80);
            this.D.setPadding(0, 0, 0, 0);
            this.x.setVisibility(8);
            this.C.setVisibility(0);
            this.y.setVisibility(8);
            this.A.setText(a2.f54446e);
            int i6 = this.v;
            if (i6 == 4) {
                this.B.setText(a2.f54448g);
                this.C.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
            } else if (i6 == 5) {
                this.B.setText(a2.f54448g);
                this.E.setText(R.string.look_normal_thread);
                this.C.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
            }
        }
        if (!TextUtils.isEmpty(a2.f54442a)) {
            this.x.V(a2.f54442a, 12, false);
        } else {
            this.x.V(null, 12, false);
        }
        this.z.setText(StringHelper.getFormatTime(a2.f54445d));
    }
}
