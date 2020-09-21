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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout iik;
    private TextView jnC;
    private ImageView jrh;
    private LinearLayout jri;
    private LinearLayout jrj;
    private OfficialSecondMenuPopupWindow jrk;
    private a[] jrl;
    private boolean jrm;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.jrm = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.jnC = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.jnC.setText(string);
        }
        this.iik = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.iik.setVisibility(0);
        this.jrh = (ImageView) this.iik.findViewById(R.id.official_bar_toggle_button);
        this.jrh.setVisibility(0);
        this.jrl = new a[3];
        a aVar = new a();
        aVar.blz = false;
        aVar.jrq = (LinearLayout) this.iik.findViewById(R.id.menu_frist);
        aVar.jrr = (TextView) this.iik.findViewById(R.id.menu_frist_text);
        aVar.jrs = (ImageView) this.iik.findViewById(R.id.menu_frist_tip);
        this.jrl[0] = aVar;
        a aVar2 = new a();
        aVar2.blz = false;
        aVar2.jrq = (LinearLayout) this.iik.findViewById(R.id.menu_second);
        aVar2.jrr = (TextView) this.iik.findViewById(R.id.menu_second_text);
        aVar2.jrs = (ImageView) this.iik.findViewById(R.id.menu_second_tip);
        this.jrl[1] = aVar2;
        a aVar3 = new a();
        aVar3.blz = false;
        aVar3.jrq = (LinearLayout) this.iik.findViewById(R.id.menu_third);
        aVar3.jrr = (TextView) this.iik.findViewById(R.id.menu_third_text);
        aVar3.jrs = (ImageView) this.iik.findViewById(R.id.menu_third_tip);
        this.jrl[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.jrl[i].jrq.setOnClickListener(talkableActivity);
        }
        this.jri = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.jri.setVisibility(0);
        this.jrj = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.jrj.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.jrh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.qu(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.jrk = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.jrk);
        this.jrk.setVisibility(8);
        this.jrk.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.jrm = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.cp_bg_line_h);
        this.mTool.setMoreDeskBgColorId(R.color.cp_bg_line_h);
        this.mTool.jh(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, m.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (m) runTask.getData();
            if (this.mSendTool.eMS != null && (this.mSendTool.eMS instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.eMS;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.eNL = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.bg(arrayList);
        m qr = this.mTool.qr(5);
        if (qr != null) {
            qr.eNL = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.eMS != null && (aVar.eMS instanceof EditText)) {
            ((EditText) aVar.eMS).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.jrm) {
            this.mTool.b(new com.baidu.tieba.im.chat.officialBar.a(talkableActivity.getActivity()));
        }
        this.mTool.build();
        this.mInputControl.addView(this.mTool, new ViewGroup.LayoutParams(-1, -2));
        this.mTool.setActionListener(24, this.mActionListener);
        this.mTool.setActionListener(8, this.mActionListener);
        this.mTool.setActionListener(4, this.mActionListener);
        this.mTool.setActionListener(14, this.mActionListener);
        if (TbadkCoreApplication.getInst().isFaceShopNew()) {
            this.mTool.b(new com.baidu.tbadk.editortools.a(2, 5, "N"));
        }
        if (this.jrm) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.qu(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow cFP() {
        return this.jrk;
    }

    public void ag(boolean z, boolean z2) {
        if (this.jrm != z) {
            if (!this.jrm) {
                this.mTool.jj(false);
                return;
            }
            this.iik.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.jri.setVisibility(0);
            return;
        }
        this.jrm = !z;
        if (z) {
            this.iik.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.jj(true);
                } else {
                    this.mTool.jj(false);
                }
            }
            this.jri.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.iik.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.jri.setVisibility(0);
    }

    public a[] cFQ() {
        return this.jrl;
    }

    public void dF(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.jrl[i].jrr.setText(bVar.getName());
                if (bVar.cHv() != 0) {
                    this.jrl[i].jrs.setVisibility(8);
                }
            }
        }
    }

    public void qt(boolean z) {
        this.jrj.setVisibility(z ? 0 : 8);
    }

    public void qu(final boolean z) {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), R.anim.parent_menu_up);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.mContext.getPageContext().getPageActivity(), R.anim.parent_menu_down);
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (z) {
                    OfficialBarMsglistView.this.iik.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.iik.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.display();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.jrl[i];
                        if (aVar.blz) {
                            aVar.blz = false;
                            OfficialBarMsglistView.this.Y(i, aVar.blz);
                            OfficialBarMsglistView.this.jrk.PE();
                        }
                    }
                }
                OfficialBarMsglistView.this.getLayoutBottom().startAnimation(loadAnimation);
            }
        });
        sendmsgCloseSoftkey();
        if (isMoreVisible()) {
            hideMore();
        }
        getLayoutBottom().startAnimation(loadAnimation2);
    }

    public void Y(int i, boolean z) {
        a aVar = this.jrl[i];
        if (z) {
            aVar.jrs.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.jrr.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.jrs.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.jrr.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int cG(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.jrl[i].jrq) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static class a {
        boolean blz;
        LinearLayout jrq;
        TextView jrr;
        ImageView jrs;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void Bo(int i) {
        if (this.jnC != null) {
            this.jnC.setText(i);
        }
    }

    public void cFR() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setViewTextColor(this.jnC, R.color.cp_link_tip_a, 1);
    }
}
