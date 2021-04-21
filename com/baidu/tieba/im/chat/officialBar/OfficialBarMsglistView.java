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
import d.b.i0.w.m;
import d.b.i0.w.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {

    /* renamed from: e  reason: collision with root package name */
    public TextView f17535e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f17536f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f17537g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17538h;
    public LinearLayout i;
    public OfficialSecondMenuPopupWindow j;
    public d[] k;
    public boolean l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OfficialBarMsglistView.this.v(false);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.i0.w.b {
        public b() {
        }

        @Override // d.b.i0.w.b
        public void onAction(d.b.i0.w.a aVar) {
            OfficialBarMsglistView.this.v(true);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f17541a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Animation f17542b;

        public c(boolean z, Animation animation) {
            this.f17541a = z;
            this.f17542b = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f17541a) {
                OfficialBarMsglistView.this.f17537g.setVisibility(0);
                if (OfficialBarMsglistView.this.mTool != null) {
                    OfficialBarMsglistView.this.mTool.o();
                }
            } else {
                OfficialBarMsglistView.this.f17537g.setVisibility(8);
                if (OfficialBarMsglistView.this.mTool != null) {
                    OfficialBarMsglistView.this.mTool.j();
                }
                for (int i = 0; i < 3; i++) {
                    d dVar = OfficialBarMsglistView.this.k[i];
                    if (dVar.f17544a) {
                        dVar.f17544a = false;
                        OfficialBarMsglistView.this.w(i, false);
                        OfficialBarMsglistView.this.j.g();
                    }
                }
            }
            OfficialBarMsglistView.this.getLayoutBottom().startAnimation(this.f17542b);
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
        public boolean f17544a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f17545b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17546c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f17547d;
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
            this.f17535e = textView;
            textView.setText(string);
        }
        LinearLayout linearLayout = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.f17537g = linearLayout;
        linearLayout.setVisibility(0);
        ImageView imageView = (ImageView) this.f17537g.findViewById(R.id.official_bar_toggle_button);
        this.f17536f = imageView;
        imageView.setVisibility(0);
        this.k = new d[3];
        d dVar = new d();
        dVar.f17544a = false;
        dVar.f17545b = (LinearLayout) this.f17537g.findViewById(R.id.menu_frist);
        dVar.f17546c = (TextView) this.f17537g.findViewById(R.id.menu_frist_text);
        dVar.f17547d = (ImageView) this.f17537g.findViewById(R.id.menu_frist_tip);
        this.k[0] = dVar;
        d dVar2 = new d();
        dVar2.f17544a = false;
        dVar2.f17545b = (LinearLayout) this.f17537g.findViewById(R.id.menu_second);
        dVar2.f17546c = (TextView) this.f17537g.findViewById(R.id.menu_second_text);
        dVar2.f17547d = (ImageView) this.f17537g.findViewById(R.id.menu_second_tip);
        this.k[1] = dVar2;
        d dVar3 = new d();
        dVar3.f17544a = false;
        dVar3.f17545b = (LinearLayout) this.f17537g.findViewById(R.id.menu_third);
        dVar3.f17546c = (TextView) this.f17537g.findViewById(R.id.menu_third_text);
        dVar3.f17547d = (ImageView) this.f17537g.findViewById(R.id.menu_third_tip);
        this.k[2] = dVar3;
        for (int i = 0; i < 3; i++) {
            this.k[i].f17545b.setOnClickListener(talkableActivity);
        }
        LinearLayout linearLayout2 = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.f17538h = linearLayout2;
        linearLayout2.setVisibility(0);
        LinearLayout linearLayout3 = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.i = linearLayout3;
        linearLayout3.setVisibility(8);
        EditorTools editorTools = this.mTool;
        if (editorTools != null) {
            editorTools.o();
        }
        this.f17536f.setOnClickListener(new a());
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
        this.mTool.d(new d.b.i0.w.r.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.h(arrayList);
        m n = this.mTool.n(5);
        if (n != null) {
            n.j = 3;
        }
        d.b.i0.w.s.a aVar = new d.b.i0.w.s.a(talkableActivity.getActivity(), false);
        aVar.h(true);
        n nVar2 = aVar.k;
        if (nVar2 != null && (nVar2 instanceof EditText)) {
            ((EditText) nVar2).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.d(aVar);
        d.b.i0.w.x.a aVar2 = new d.b.i0.w.x.a(talkableActivity.getActivity());
        aVar2.g(R.string.send_msg);
        this.mTool.d(aVar2);
        if (this.l) {
            this.mTool.d(new d.b.j0.e1.f.j.a(talkableActivity.getActivity()));
        }
        this.mTool.f();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.A(new d.b.i0.w.a(2, 5, "N"));
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
        for (int i = 0; i < 3; i++) {
            if (view == this.k[i].f17545b) {
                return i;
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
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        SkinManager.setViewTextColor(this.f17535e, R.color.CAM_X0302, 1);
    }

    public void q(int i) {
        TextView textView = this.f17535e;
        if (textView != null) {
            textView.setText(i);
        }
    }

    public void r(boolean z, boolean z2) {
        boolean z3 = this.l;
        if (z3 != z) {
            if (!z3) {
                this.mTool.k(false);
                return;
            }
            this.f17537g.setVisibility(0);
            EditorTools editorTools = this.mTool;
            if (editorTools != null) {
                editorTools.o();
            }
            this.f17538h.setVisibility(0);
            return;
        }
        this.l = !z;
        if (z) {
            this.f17537g.setVisibility(8);
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
            this.f17538h.setVisibility(8);
            return;
        }
        EditorTools editorTools3 = this.mTool;
        if (editorTools3 != null) {
            this.mInputControl.removeView(editorTools3);
            initMsgSend(((AbsMsglistView) this).mContext);
            this.mTool.w(TbadkCoreApplication.getInst().getSkinType());
        }
        this.f17537g.setVisibility(0);
        EditorTools editorTools4 = this.mTool;
        if (editorTools4 != null) {
            editorTools4.o();
        }
        this.f17538h.setVisibility(0);
    }

    public void s(List<d.b.j0.e1.g.b> list) {
        if (list == null || list.size() != 3) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            d.b.j0.e1.g.b bVar = list.get(i);
            this.k[i].f17546c.setText(bVar.d());
            if (bVar.a() != 0) {
                this.k[i].f17547d.setVisibility(8);
            }
        }
    }

    public void u(boolean z) {
        this.i.setVisibility(z ? 0 : 8);
    }

    public void v(boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(((AbsMsglistView) this).mContext.getPageContext().getPageActivity(), R.anim.parent_menu_up);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(((AbsMsglistView) this).mContext.getPageContext().getPageActivity(), R.anim.parent_menu_down);
        loadAnimation2.setAnimationListener(new c(z, loadAnimation));
        sendmsgCloseSoftkey();
        if (isMoreVisible()) {
            hideMore();
        }
        getLayoutBottom().startAnimation(loadAnimation2);
    }

    public void w(int i, boolean z) {
        d dVar = this.k[i];
        if (z) {
            dVar.f17547d.setImageResource(R.drawable.icon_bottombar_arrow_s);
            dVar.f17546c.setTextColor(((AbsMsglistView) this).mContext.getResources().getColor(R.color.CAM_X0302));
            return;
        }
        dVar.f17547d.setImageResource(R.drawable.icon_bottombar_arrow_n);
        dVar.f17546c.setTextColor(((AbsMsglistView) this).mContext.getResources().getColor(R.color.CAM_X0106));
    }
}
