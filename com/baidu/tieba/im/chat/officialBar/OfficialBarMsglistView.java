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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.view.OfficialSecondMenuPopupWindow;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private LinearLayout hfi;
    private TextView idg;
    private ImageView igk;
    private LinearLayout igl;
    private LinearLayout igm;
    private OfficialSecondMenuPopupWindow ign;
    private a[] igo;
    private boolean igp;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.igp = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initHeader(talkableActivity, z);
        String string = talkableActivity.getPageContext().getString(R.string.forum_detail_title);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.group_info_btn, talkableActivity);
            this.mNavigationBar.showBottomLine();
            this.idg = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.idg.setText(string);
        }
        this.hfi = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_stub)).inflate();
        this.hfi.setVisibility(0);
        this.igk = (ImageView) this.hfi.findViewById(R.id.official_bar_toggle_button);
        this.igk.setVisibility(0);
        this.igo = new a[3];
        a aVar = new a();
        aVar.igt = false;
        aVar.igu = (LinearLayout) this.hfi.findViewById(R.id.menu_frist);
        aVar.igv = (TextView) this.hfi.findViewById(R.id.menu_frist_text);
        aVar.igw = (ImageView) this.hfi.findViewById(R.id.menu_frist_tip);
        this.igo[0] = aVar;
        a aVar2 = new a();
        aVar2.igt = false;
        aVar2.igu = (LinearLayout) this.hfi.findViewById(R.id.menu_second);
        aVar2.igv = (TextView) this.hfi.findViewById(R.id.menu_second_text);
        aVar2.igw = (ImageView) this.hfi.findViewById(R.id.menu_second_tip);
        this.igo[1] = aVar2;
        a aVar3 = new a();
        aVar3.igt = false;
        aVar3.igu = (LinearLayout) this.hfi.findViewById(R.id.menu_third);
        aVar3.igv = (TextView) this.hfi.findViewById(R.id.menu_third_text);
        aVar3.igw = (ImageView) this.hfi.findViewById(R.id.menu_third_tip);
        this.igo[2] = aVar3;
        for (int i = 0; i < 3; i++) {
            this.igo[i].igu.setOnClickListener(talkableActivity);
        }
        this.igl = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_memu_down_line)).inflate();
        this.igl.setVisibility(0);
        this.igm = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.official_bar_menu_loading)).inflate();
        this.igm.setVisibility(8);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.igk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfficialBarMsglistView.this.ot(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsglist(MsglistActivity msglistActivity) {
        super.initMsglist(msglistActivity);
        this.ign = new OfficialSecondMenuPopupWindow(msglistActivity.getPageContext().getPageActivity());
        getListMain().addView(this.ign);
        this.ign.setVisibility(8);
        this.ign.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
        this.igp = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initMsgSend(TalkableActivity talkableActivity) {
        this.mTool = new EditorTools(talkableActivity.getActivity());
        this.mTool.setBarMaxLauCount(1);
        this.mTool.setMoreButtonAtEnd(true);
        this.mTool.setDeskBackgroundColorId(R.color.cp_bg_line_h);
        this.mTool.setMoreDeskBgColorId(R.color.cp_bg_line_h);
        this.mTool.hA(true);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_CHAT_SEND_VOICE_VIEW, l.class, talkableActivity.getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.mSendTool = (l) runTask.getData();
            if (this.mSendTool.dWM != null && (this.mSendTool.dWM instanceof ISendVoiceView)) {
                this.mSendVoiceView = (ISendVoiceView) this.mSendTool.dWM;
                if (this.mSendVoiceView instanceof View) {
                    ((View) this.mSendVoiceView).setOnTouchListener(this.mContext);
                }
            }
            this.mSendTool.dXC = 1;
            this.mTool.b(this.mSendTool);
        }
        this.mTool.b(new com.baidu.tbadk.editortools.imagetool.d(talkableActivity.getActivity(), 2));
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        arrayList.add(10);
        arrayList.add(5);
        this.mTool.aR(arrayList);
        l mD = this.mTool.mD(5);
        if (mD != null) {
            mD.dXC = 3;
        }
        com.baidu.tbadk.editortools.inputtool.a aVar = new com.baidu.tbadk.editortools.inputtool.a(talkableActivity.getActivity(), false);
        aVar.setIsOnlyLocalEmotion(true);
        if (aVar.dWM != null && (aVar.dWM instanceof EditText)) {
            ((EditText) aVar.dWM).setTextSize(0, talkableActivity.getActivity().getResources().getDimensionPixelSize(R.dimen.ds34));
        }
        this.mTool.b(aVar);
        com.baidu.tbadk.editortools.sendtool.a aVar2 = new com.baidu.tbadk.editortools.sendtool.a(talkableActivity.getActivity());
        aVar2.setText(R.string.send_msg);
        this.mTool.b(aVar2);
        if (this.igp) {
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
        if (this.igp) {
            this.mTool.setActionListener(30, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarMsglistView.2
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar3) {
                    OfficialBarMsglistView.this.ot(true);
                }
            });
        }
    }

    public OfficialSecondMenuPopupWindow cdq() {
        return this.ign;
    }

    public void V(boolean z, boolean z2) {
        if (this.igp != z) {
            if (!this.igp) {
                this.mTool.hC(false);
                return;
            }
            this.hfi.setVisibility(0);
            if (this.mTool != null) {
                this.mTool.hide();
            }
            this.igl.setVisibility(0);
            return;
        }
        this.igp = !z;
        if (z) {
            this.hfi.setVisibility(8);
            if (this.mTool != null) {
                this.mInputControl.removeView(this.mTool);
                initMsgSend(this.mContext);
                this.mTool.onChangeSkinType(0);
                if (z2) {
                    this.mTool.hC(true);
                } else {
                    this.mTool.hC(false);
                }
            }
            this.igl.setVisibility(8);
            return;
        }
        if (this.mTool != null) {
            this.mInputControl.removeView(this.mTool);
            initMsgSend(this.mContext);
            this.mTool.onChangeSkinType(0);
        }
        this.hfi.setVisibility(0);
        if (this.mTool != null) {
            this.mTool.hide();
        }
        this.igl.setVisibility(0);
    }

    public a[] cdr() {
        return this.igo;
    }

    public void cY(List<com.baidu.tieba.im.data.b> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.b bVar = list.get(i);
                this.igo[i].igv.setText(bVar.getName());
                if (bVar.ceW() != 0) {
                    this.igo[i].igw.setVisibility(8);
                }
            }
        }
    }

    public void os(boolean z) {
        this.igm.setVisibility(z ? 0 : 8);
    }

    public void ot(final boolean z) {
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
                    OfficialBarMsglistView.this.hfi.setVisibility(0);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.hide();
                    }
                } else {
                    OfficialBarMsglistView.this.hfi.setVisibility(8);
                    if (OfficialBarMsglistView.this.mTool != null) {
                        OfficialBarMsglistView.this.mTool.display();
                    }
                    for (int i = 0; i < 3; i++) {
                        a aVar = OfficialBarMsglistView.this.igo[i];
                        if (aVar.igt) {
                            aVar.igt = false;
                            OfficialBarMsglistView.this.P(i, aVar.igt);
                            OfficialBarMsglistView.this.ign.FX();
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

    public void P(int i, boolean z) {
        a aVar = this.igo[i];
        if (z) {
            aVar.igw.setImageResource(R.drawable.icon_bottombar_arrow_s);
            aVar.igv.setTextColor(this.mContext.getResources().getColor(R.color.cp_link_tip_a));
            return;
        }
        aVar.igw.setImageResource(R.drawable.icon_bottombar_arrow_n);
        aVar.igv.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
    }

    public int cn(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.igo[i].igu) {
                return i;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        boolean igt;
        LinearLayout igu;
        TextView igv;
        ImageView igw;

        a() {
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }

    public void wJ(int i) {
        if (this.idg != null) {
            this.idg.setText(i);
        }
    }

    public void cds() {
        if (this.mLayBottom != null) {
            this.mLayBottom.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.setViewTextColor(this.idg, R.color.cp_link_tip_a, 1);
    }
}
