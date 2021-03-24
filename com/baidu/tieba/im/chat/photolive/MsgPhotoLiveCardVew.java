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
import d.b.b.e.p.l;
import d.b.i0.c3.n0.c;
import d.b.i0.d1.f.e;
import d.b.i0.d1.f.k.a;
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
                msgPhotoLiveCardVew2.Q(msgPhotoLiveCardVew2.v);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MsgPhotoLiveCardVew.this.P(view);
        }
    }

    public MsgPhotoLiveCardVew(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, R.layout.msg_photolive_card_view);
        this.t = 0L;
        this.v = 0;
        this.F = 0;
        this.F = l.g(tbPageContext.getContext(), R.dimen.ds24);
        R();
    }

    public final SpannableStringBuilder M(String str, int i) {
        if (str == null || "".equals(str)) {
            return null;
        }
        int indexOf = str.indexOf(String.valueOf(i));
        int O = O(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)), indexOf, O + indexOf, 33);
        return spannableStringBuilder;
    }

    public final int O(int i) {
        int i2 = 0;
        do {
            i /= 10;
            i2++;
        } while (i != 0);
        return i2;
    }

    public final void P(View view) {
        Object tag = view.getTag();
        if (tag instanceof String) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), (String) tag, "")));
        }
    }

    public final void Q(int i) {
        if (i == 5 || i == 6) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createNormalCfg(String.valueOf(this.t), null, "message_tab")));
        }
    }

    public final void R() {
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

    public void S(TbPageContext<?> tbPageContext, ChatMessage chatMessage, View view) {
        String decode;
        int i;
        if (chatMessage == null) {
            return;
        }
        a.C1194a a2 = d.b.i0.d1.f.k.a.a(chatMessage.getContent());
        if (a2 == null) {
            this.t = 0L;
            return;
        }
        this.t = a2.f53752f;
        long j = a2.f53754h;
        this.v = a2.i;
        int i2 = a2.j;
        ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        int i3 = this.v;
        int i4 = -1;
        if (i3 == 1 || i3 == 6) {
            if (this.v == 1) {
                decode = a2.f53753g;
                i = R.string.look_live_thread;
            } else {
                decode = URLDecoder.decode(a2.f53753g);
                i = R.string.look_god_thread;
                i4 = 0;
            }
            this.B.setText(decode);
            layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds72);
            this.D.setPadding(this.F, 0, 0, 0);
            this.x.setVisibility(0);
            this.x.setOnClickListener(new b());
            this.x.setTag(a2.f53748b);
            this.x.setGodIconMargin(i4);
            this.C.setVisibility(8);
            this.y.setVisibility(0);
            this.y.setText(a2.f53749c);
            this.A.setText(a2.f53751e);
            this.y.setTextSize(0, l.g(TbadkCoreApplication.getInst(), R.dimen.fontsize28));
            this.E.setText(i);
        } else if (i3 == 3) {
            this.B.setText(a2.f53753g);
            layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds80);
            this.D.setPadding(0, 0, 0, 0);
            this.x.setVisibility(8);
            this.C.setVisibility(0);
            this.y.setVisibility(8);
            this.C.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.fans_urge_tips));
            String str = a2.f53751e;
            if (str != null && str.indexOf(String.valueOf(i2)) != -1) {
                this.A.setText(M(a2.f53751e, i2));
            } else {
                this.A.setText(a2.f53751e);
            }
        } else {
            layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.ds80);
            this.D.setPadding(0, 0, 0, 0);
            this.x.setVisibility(8);
            this.C.setVisibility(0);
            this.y.setVisibility(8);
            this.A.setText(a2.f53751e);
            int i5 = this.v;
            if (i5 == 4) {
                this.B.setText(a2.f53753g);
                this.C.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.upgrade_to_photo_live_tips));
            } else if (i5 == 5) {
                this.B.setText(a2.f53753g);
                this.E.setText(R.string.look_normal_thread);
                this.C.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.change_to_old_thread_msg_tips));
            }
        }
        if (!TextUtils.isEmpty(a2.f53747a)) {
            this.x.W(a2.f53747a, 12, false);
        } else {
            this.x.W(null, 12, false);
        }
        this.z.setText(StringHelper.getFormatTime(a2.f53750d));
    }
}
