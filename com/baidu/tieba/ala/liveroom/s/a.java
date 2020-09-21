package com.baidu.tieba.ala.liveroom.s;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class a extends Dialog implements View.OnClickListener {
    private String aBm;
    private boolean bej;
    private TextView dEG;
    private TextView gLf;
    private TextView gLg;
    private TextView gLh;
    private View gLi;
    private View gLj;
    private PersonUserData gLk;
    private b gLl;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0635a {
        void onConfirm();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void GM(String str);

        void GN(String str);

        void GO(String str);

        void GP(String str);

        void GQ(String str);

        void GR(String str);

        void bXR();

        void onCancel();
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), a.j.theme_manage_dialog);
        this.mPageContext = tbPageContext;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.ala_person_dialog_manage);
        resize();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.gLf = (TextView) findViewById(a.g.ala_person_forbid_this);
        this.gLi = findViewById(a.g.ala_person_forbid_this_divider);
        this.gLg = (TextView) findViewById(a.g.ala_person_forbid_forever);
        this.gLj = findViewById(a.g.ala_person_forbid_this_divider);
        this.gLh = (TextView) findViewById(a.g.ala_person_admin);
        this.dEG = (TextView) findViewById(a.g.ala_person_manage_cancel);
        this.gLf.setOnClickListener(this);
        this.gLg.setOnClickListener(this);
        this.gLh.setOnClickListener(this);
        this.dEG.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.gLl != null) {
            if (view == this.gLf) {
                if (this.gLk != null && this.gLk.user_info != null) {
                    if (bXL()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0635a() { // from class: com.baidu.tieba.ala.liveroom.s.a.1
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0635a
                            public void onConfirm() {
                                if (a.this.gLk != null && a.this.gLk.user_info != null) {
                                    a.this.gLk.user_info.is_block = 0;
                                    a.this.gLl.GO(a.this.gLk.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.gLk.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0635a() { // from class: com.baidu.tieba.ala.liveroom.s.a.2
                        @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0635a
                        public void onConfirm() {
                            if (a.this.gLk != null && a.this.gLk.user_info != null) {
                                a.this.gLk.user_info.is_block = 1;
                                a.this.gLl.GM(a.this.gLk.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_this_confirm_tip), this.gLk.user_info.getNameShow()));
                }
            } else if (view == this.gLg) {
                if (this.gLk != null && this.gLk.user_info != null) {
                    if (bXK()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0635a() { // from class: com.baidu.tieba.ala.liveroom.s.a.3
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0635a
                            public void onConfirm() {
                                if (a.this.gLk != null && a.this.gLk.user_info != null) {
                                    a.this.gLk.user_info.is_block = 0;
                                    a.this.gLl.GP(a.this.gLk.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_relieve_forbidden_confirm_tip), this.gLk.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0635a() { // from class: com.baidu.tieba.ala.liveroom.s.a.4
                        @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0635a
                        public void onConfirm() {
                            if (a.this.gLk != null && a.this.gLk.user_info != null) {
                                a.this.gLk.user_info.is_block = 2;
                                a.this.gLl.GN(a.this.gLk.user_info.user_id);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.i.ala_person_forbid_forever_confirm_tip), this.gLk.user_info.getNameShow()));
                }
            } else if (view == this.gLh) {
                if (this.gLk != null && this.gLk.login_user_info != null) {
                    if (bXM()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0635a() { // from class: com.baidu.tieba.ala.liveroom.s.a.5
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0635a
                            public void onConfirm() {
                                if (a.this.gLk != null && a.this.gLk.login_user_info != null) {
                                    a.this.gLk.login_user_info.is_live_admin = 1;
                                    a.this.gLl.GQ(a.this.gLk.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_appoint_admin_confirm_tip), this.gLk.user_info.getNameShow()));
                    } else if (bXN()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0635a() { // from class: com.baidu.tieba.ala.liveroom.s.a.6
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0635a
                            public void onConfirm() {
                                if (a.this.gLk != null && a.this.gLk.login_user_info != null) {
                                    a.this.gLk.login_user_info.is_live_admin = 0;
                                    a.this.gLl.GR(a.this.gLk.user_info.user_id);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.i.ala_person_fire_admin_confirm_tip), this.gLk.user_info.getNameShow()));
                    } else if (bXO()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0635a() { // from class: com.baidu.tieba.ala.liveroom.s.a.7
                            @Override // com.baidu.tieba.ala.liveroom.s.a.InterfaceC0635a
                            public void onConfirm() {
                                if (a.this.gLk != null && a.this.gLk.login_user_info != null) {
                                    a.this.gLk.login_user_info.is_live_admin = 0;
                                    a.this.gLl.bXR();
                                }
                            }
                        }, getContext().getResources().getString(a.i.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.dEG) {
                this.gLl.onCancel();
            }
        }
    }

    private void a(final InterfaceC0635a interfaceC0635a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0635a != null) {
                    interfaceC0635a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.a.9
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(this.mPageContext).show();
    }

    public void a(PersonUserData personUserData, boolean z, String str) {
        super.show();
        if (personUserData != null) {
            b(personUserData, z, str);
        }
    }

    public void b(PersonUserData personUserData, boolean z, String str) {
        this.gLk = personUserData;
        this.bej = z;
        this.aBm = str;
        if (bXP() || bXQ()) {
            uW(8);
            uX(8);
        } else if (bXK()) {
            uW(8);
            this.gLg.setText(a.i.ala_person_relieve_forbidden_forever);
        } else if (bXL()) {
            uW(0);
            this.gLf.setText(a.i.ala_person_relieve_forbidden_this);
            this.gLg.setText(a.i.ala_person_forbid_forever);
        } else {
            uW(0);
            this.gLf.setText(a.i.ala_person_forbid_this);
            this.gLg.setText(a.i.ala_person_forbid_forever);
        }
        if (bXJ()) {
            this.gLh.setVisibility(8);
            this.gLj.setVisibility(8);
        } else if (bXN()) {
            this.gLh.setText(a.i.ala_person_fire_admin);
        } else if (bXM()) {
            this.gLh.setText(a.i.ala_person_appoint_admin);
        } else if (bXP() && bXO()) {
            this.gLh.setText(a.i.ala_person_resign_admin);
        } else {
            this.gLh.setVisibility(8);
            this.gLj.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.gLl = bVar;
    }

    private boolean bXJ() {
        return (this.gLk == null || this.gLk.user_info == null || this.gLk.user_info.is_block <= 0) ? false : true;
    }

    private boolean bXK() {
        return (this.gLk == null || this.gLk.user_info == null || this.gLk.user_info.is_block != 2) ? false : true;
    }

    private boolean bXL() {
        return (this.gLk == null || this.gLk.user_info == null || this.gLk.user_info.is_block != 1) ? false : true;
    }

    private boolean bXM() {
        return this.gLk != null && this.gLk.user_info != null && this.bej && this.gLk.user_info.is_live_admin == 0;
    }

    private boolean bXN() {
        return this.gLk != null && this.gLk.user_info != null && this.bej && this.gLk.user_info.is_live_admin == 1;
    }

    private boolean bXO() {
        return (this.gLk == null || this.gLk.login_user_info == null || this.bej || this.gLk.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean bXP() {
        return (this.gLk == null || this.gLk.user_info == null || TextUtils.isEmpty(this.aBm) || !this.aBm.equals(this.gLk.user_info.user_id)) ? false : true;
    }

    private boolean bXQ() {
        return (this.gLk == null || this.gLk.user_info == null || this.gLk.user_info.is_live_admin != 1) ? false : true;
    }

    private void uW(int i) {
        this.gLf.setVisibility(i);
        this.gLi.setVisibility(i);
    }

    private void uX(int i) {
        this.gLg.setVisibility(i);
        this.gLj.setVisibility(i);
    }

    public void resize() {
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mPageContext.getPageActivity());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2) {
            attributes.width = Math.max(screenDimensions[0], screenDimensions[1]);
        } else {
            attributes.width = Math.min(screenDimensions[0], screenDimensions[1]);
        }
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
