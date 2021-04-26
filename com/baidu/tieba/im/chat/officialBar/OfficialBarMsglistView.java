package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import d.a.i0.w.m;
import d.a.i0.w.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {

    /* renamed from: e  reason: collision with root package name */
    public TextView f17851e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f17852f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f17853g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17854h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f17855i;
    public OfficialSecondMenuPopupWindow j;
    public d[] k;
    public boolean l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OfficialBarMsglistView.this.t(false);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.i0.w.b {
        public b() {
        }

        @Override // d.a.i0.w.b
        public void onAction(d.a.i0.w.a aVar) {
            OfficialBarMsglistView.this.t(true);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f17858a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Animation f17859b;

        public c(boolean z, Animation animation) {
            this.f17858a = z;
            this.f17859b = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f17858a) {
                OfficialBarMsglistView.this.f17853g.setVisibility(0);
                if (OfficialBarMsglistView.this.mTool != null) {
                    OfficialBarMsglistView.this.mTool.o();
                }
            } else {
                OfficialBarMsglistView.this.f17853g.setVisibility(8);
                if (OfficialBarMsglistView.this.mTool != null) {
                    OfficialBarMsglistView.this.mTool.j();
                }
                for (int i2 = 0; i2 < 3; i2++) {
                    d dVar = OfficialBarMsglistView.this.k[i2];
                    if (dVar.f17861a) {
                        dVar.f17861a = false;
                        OfficialBarMsglistView.this.u(i2, false);
                        OfficialBarMsglistView.this.j.g();
                    }
                }
            }
            OfficialBarMsglistView.this.getLayoutBottom().startAnimation(this.f17859b);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f17861a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f17862b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17863c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f17864d;
    }

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.l = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            TextView textView = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.f17851e = textView;
            textView.setText(string);
        }
        LinearLayout linearLayout = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.f17853g = linearLayout;
        linearLayout.setVisibility(0);
        ImageView imageView = (ImageView) this.f17853g.findViewById(R.id.official_bar_toggle_button);
        this.f17852f = imageView;
        imageView.setVisibility(0);
        this.k = new d[3];
        d dVar = new d();
        dVar.f17861a = false;
        dVar.f17862b = (LinearLayout) this.f17853g.findViewById(R.id.menu_frist);
        dVar.f17863c = (TextView) this.f17853g.findViewById(R.id.menu_frist_text);
        dVar.f17864d = (ImageView) this.f17853g.findViewById(R.id.menu_frist_tip);
        this.k[0] = dVar;
        d dVar2 = new d();
        dVar2.f17861a = false;
        dVar2.f17862b = (LinearLayout) this.f17853g.findViewById(R.id.menu_second);
        dVar2.f17863c = (TextView) this.f17853g.findViewById(R.id.menu_second_text);
        dVar2.f17864d = (ImageView) this.f17853g.findViewById(R.id.menu_second_tip);
        this.k[1] = dVar2;
        d dVar3 = new d();
        dVar3.f17861a = false;
        dVar3.f17862b = (LinearLayout) this.f17853g.findViewById(R.id.menu_third);
        dVar3.f17863c = (TextView) this.f17853g.findViewById(R.id.menu_third_text);
        dVar3.f17864d = (ImageView) this.f17853g.findViewById(R.id.menu_third_tip);
        this.k[2] = dVar3;
        for (int i2 = 0; i2 < 3; i2++) {
            this.k[i2].f17862b.setOnClickListener(talkableActivity);
        }
        LinearLayout linearLayout2 = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.f17854h = linearLayout2;
        linearLayout2.setVisibility(0);
        LinearLayout linearLayout3 = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.f17855i = linearLayout3;
        linearLayout3.setVisibility(8);
        EditorTools editorTools = this.mTool;
        if (editorTools != null) {
            editorTools.o();
        }
        this.f17852f.setOnClickListener(new a());
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsgSend(TalkableActivity talkableActivity) {
        EditorTools editorTools = new EditorTools(talkableActivity.getActivity());
        this.mTool = editorTools;
        editorTools.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setBackgroundColorId(R.color.CAM_X0204);
        this.mTool.setBarBackgroundColorId(R.color.CAM_X0207);
        this.mTool.setDeskBackgroundColorId(R.color.CAM_X0206);
        this.mTool.setMoreDeskBgColorId(R.color.CAM_X0206);
        this.mTool.C(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, m.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            m mVar = (m) runTask.getData();
            this.mSendTool = mVar;
            n nVar = mVar.k;
            if (nVar != null && (nVar instanceof ISendVoiceView)) {
                ISendVoiceView iSendVoiceView = (ISendVoiceView) nVar;
                this.mSendVoiceView = iSendVoiceView;
                if (iSendVoiceView instanceof View) {
                    ((View) iSendVoiceView).setOnTouchListener(((AbsMsglistView) this).mContext);
                }
            }
            m mVar2 = this.mSendTool;
            mVar2.j = 1;
            this.mTool.d(mVar2);
        }
        this.mTool.d(new d.a.i0.w.r.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.h(arrayList);
        m n = this.mTool.n(5);
        if (n != null) {
            n.j = 3;
        }
        d.a.i0.w.s.a aVar = new d.a.i0.w.s.a(talkableActivity.getActivity(), false);
        aVar.h(true);
        n nVar2 = aVar.k;
        if (nVar2 != null && (nVar2 instanceof EditText)) {
            ((EditText) nVar2).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.d(aVar);
        d.a.i0.w.x.a aVar2 = new d.a.i0.w.x.a(talkableActivity.getActivity());
        aVar2.g(R.string.send_msg);
        this.mTool.d(aVar2);
        if (this.l) {
            this.mTool.d(new d.a.j0.e1.f.j.a(talkableActivity.getActivity()));
        }
        this.mTool.f();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.A(new d.a.i0.w.a(2, 5, "N"));
        }
        if (this.l) {
            this.mTool.setActionListener(30, new b());
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.j = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.j);
        this.j.setVisibility(8);
        this.j.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.l = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public boolean isPersonal() {
        return false;
    }

    public int l(View view) {
        for (int i2 = 0; i2 < 3; i2++) {
            if (view == this.k[i2].f17862b) {
                return i2;
            }
        }
        return 0;
    }

    public d[] m() {
        return this.k;
    }

    public OfficialSecondMenuPopupWindow n() {
        return this.j;
    }

    public void o() {
        ViewGroup viewGroup = this.mLayBottom;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        SkinManager.setViewTextColor(this.f17851e, R.color.CAM_X0302, 1);
    }

    public void p(int i2) {
        TextView textView = this.f17851e;
        if (textView != null) {
            textView.setText(i2);
        }
    }

    public void q(boolean z, boolean z2) {
        boolean z3 = this.l;
        if (z3 != z) {
            if (!z3) {
                this.mTool.k(false);
                return;
            }
            this.f17853g.setVisibility(0);
            EditorTools editorTools = this.mTool;
            if (editorTools != null) {
                editorTools.o();
            }
            this.f17854h.setVisibility(0);
            return;
        }
        this.l = !z;
        if (z) {
            this.f17853g.setVisibility(8);
            EditorTools editorTools2 = this.mTool;
            if (editorTools2 != null) {
                this.mInputControl.removeView(editorTools2);
                initMsgSend(((AbsMsglistView) this).mContext);
                this.mTool.w(TbadkCoreApplication.getInst().getSkinType());
                if (z2) {
                    this.mTool.k(true);
                } else {
                    this.mTool.k(false);
                }
            }
            this.f17854h.setVisibility(8);
            return;
        }
        EditorTools editorTools3 = this.mTool;
        if (editorTools3 != null) {
            this.mInputControl.removeView(editorTools3);
            initMsgSend(((AbsMsglistView) this).mContext);
            this.mTool.w(TbadkCoreApplication.getInst().getSkinType());
        }
        this.f17853g.setVisibility(0);
        EditorTools editorTools4 = this.mTool;
        if (editorTools4 != null) {
            editorTools4.o();
        }
        this.f17854h.setVisibility(0);
    }

    public void r(List<d.a.j0.e1.g.b> list) {
        if (list == null || list.size() != 3) {
            return;
        }
        for (int i2 = 0; i2 < 3; i2++) {
            d.a.j0.e1.g.b bVar = list.get(i2);
            this.k[i2].f17863c.setText(bVar.d());
            if (bVar.a() != 0) {
                this.k[i2].f17864d.setVisibility(8);
            }
        }
    }

    public void s(boolean z) {
        this.f17855i.setVisibility(z ? 0 : 8);
    }

    public void t(boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(((AbsMsglistView) this).mContext.getPageContext().getPageActivity(), R.anim.parent_menu_up);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(((AbsMsglistView) this).mContext.getPageContext().getPageActivity(), R.anim.parent_menu_down);
        loadAnimation2.setAnimationListener(new c(z, loadAnimation));
        sendmsgCloseSoftkey();
        if (isMoreVisible()) {
            hideMore();
        }
        getLayoutBottom().startAnimation(loadAnimation2);
    }

    public void u(int i2, boolean z) {
        d dVar = this.k[i2];
        if (z) {
            dVar.f17864d.setImageResource(R.drawable.icon_bottombar_arrow_s);
            dVar.f17863c.setTextColor(((AbsMsglistView) this).mContext.getResources().getColor(R.color.CAM_X0302));
            return;
        }
        dVar.f17864d.setImageResource(R.drawable.icon_bottombar_arrow_n);
        dVar.f17863c.setTextColor(((AbsMsglistView) this).mContext.getResources().getColor(R.color.CAM_X0106));
    }
}
