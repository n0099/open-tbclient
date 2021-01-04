package com.baidu.tieba.ala.liveroom.r;

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
/* loaded from: classes11.dex */
public class a extends Dialog implements View.OnClickListener {
    private String aGB;
    private TextView bYR;
    private boolean boZ;
    private TextView hNd;
    private TextView hNe;
    private TextView hNf;
    private View hNg;
    private View hNh;
    private PersonUserData hNi;
    private b hNj;
    private int hNk;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0688a {
        void onConfirm();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void aM(String str, int i);

        void aN(String str, int i);

        void aO(String str, int i);

        void aP(String str, int i);

        void aQ(String str, int i);

        void aR(String str, int i);

        void onCancel();

        void xz(int i);
    }

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), a.i.theme_manage_dialog);
        this.hNk = 0;
        this.mPageContext = tbPageContext;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.ala_person_dialog_manage);
        resize();
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.hNd = (TextView) findViewById(a.f.ala_person_forbid_this);
        this.hNg = findViewById(a.f.ala_person_forbid_this_divider);
        this.hNe = (TextView) findViewById(a.f.ala_person_forbid_forever);
        this.hNh = findViewById(a.f.ala_person_forbid_this_divider);
        this.hNf = (TextView) findViewById(a.f.ala_person_admin);
        this.bYR = (TextView) findViewById(a.f.ala_person_manage_cancel);
        this.hNd.setOnClickListener(this);
        this.hNe.setOnClickListener(this);
        this.hNf.setOnClickListener(this);
        this.bYR.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.hNj != null) {
            if (view == this.hNd) {
                if (this.hNi != null && this.hNi.user_info != null) {
                    if (cmV()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0688a() { // from class: com.baidu.tieba.ala.liveroom.r.a.1
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0688a
                            public void onConfirm() {
                                if (a.this.hNi != null && a.this.hNi.user_info != null) {
                                    a.this.hNi.user_info.is_block = 0;
                                    a.this.hNj.aO(a.this.hNi.user_info.user_id, a.this.hNk);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_relieve_forbidden_confirm_tip), this.hNi.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12267");
                    a(new InterfaceC0688a() { // from class: com.baidu.tieba.ala.liveroom.r.a.2
                        @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0688a
                        public void onConfirm() {
                            if (a.this.hNi != null && a.this.hNi.user_info != null) {
                                a.this.hNi.user_info.is_block = 1;
                                a.this.hNj.aM(a.this.hNi.user_info.user_id, a.this.hNk);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.h.ala_person_forbid_this_confirm_tip), this.hNi.user_info.getNameShow()));
                }
            } else if (view == this.hNe) {
                if (this.hNi != null && this.hNi.user_info != null) {
                    if (cmU()) {
                        TiebaInitialize.log("c12271");
                        a(new InterfaceC0688a() { // from class: com.baidu.tieba.ala.liveroom.r.a.3
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0688a
                            public void onConfirm() {
                                if (a.this.hNi != null && a.this.hNi.user_info != null) {
                                    a.this.hNi.user_info.is_block = 0;
                                    a.this.hNj.aP(a.this.hNi.user_info.user_id, a.this.hNk);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_relieve_forbidden_confirm_tip), this.hNi.user_info.getNameShow()));
                        return;
                    }
                    TiebaInitialize.log("c12268");
                    a(new InterfaceC0688a() { // from class: com.baidu.tieba.ala.liveroom.r.a.4
                        @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0688a
                        public void onConfirm() {
                            if (a.this.hNi != null && a.this.hNi.user_info != null) {
                                a.this.hNi.user_info.is_block = 2;
                                a.this.hNj.aN(a.this.hNi.user_info.user_id, a.this.hNk);
                            }
                        }
                    }, String.format(getContext().getResources().getString(a.h.ala_person_forbid_forever_confirm_tip), this.hNi.user_info.getNameShow()));
                }
            } else if (view == this.hNf) {
                if (this.hNi != null && this.hNi.login_user_info != null) {
                    if (cmW()) {
                        TiebaInitialize.log("c12270");
                        a(new InterfaceC0688a() { // from class: com.baidu.tieba.ala.liveroom.r.a.5
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0688a
                            public void onConfirm() {
                                if (a.this.hNi != null && a.this.hNi.login_user_info != null) {
                                    a.this.hNi.login_user_info.is_live_admin = 1;
                                    a.this.hNj.aQ(a.this.hNi.user_info.user_id, a.this.hNk);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_appoint_admin_confirm_tip), this.hNi.user_info.getNameShow()));
                    } else if (cmX()) {
                        TiebaInitialize.log("c12272");
                        a(new InterfaceC0688a() { // from class: com.baidu.tieba.ala.liveroom.r.a.6
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0688a
                            public void onConfirm() {
                                if (a.this.hNi != null && a.this.hNi.login_user_info != null) {
                                    a.this.hNi.login_user_info.is_live_admin = 0;
                                    a.this.hNj.aR(a.this.hNi.user_info.user_id, a.this.hNk);
                                }
                            }
                        }, String.format(getContext().getResources().getString(a.h.ala_person_fire_admin_confirm_tip), this.hNi.user_info.getNameShow()));
                    } else if (cmY()) {
                        TiebaInitialize.log("c12269");
                        a(new InterfaceC0688a() { // from class: com.baidu.tieba.ala.liveroom.r.a.7
                            @Override // com.baidu.tieba.ala.liveroom.r.a.InterfaceC0688a
                            public void onConfirm() {
                                if (a.this.hNi != null && a.this.hNi.login_user_info != null) {
                                    a.this.hNi.login_user_info.is_live_admin = 0;
                                    a.this.hNj.xz(a.this.hNk);
                                }
                            }
                        }, getContext().getResources().getString(a.h.ala_person_resign_admin_confirm_tip));
                    }
                }
            } else if (view == this.bYR) {
                this.hNj.onCancel();
            }
        }
    }

    private void a(final InterfaceC0688a interfaceC0688a, String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.r.a.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (interfaceC0688a != null) {
                    interfaceC0688a.onConfirm();
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.r.a.9
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
        this.hNi = personUserData;
        this.boZ = z;
        this.aGB = str;
        if (this.hNi != null && this.hNi.user_info != null && this.hNi.user_info.extInfoJson != null) {
            if (this.hNi.user_info.extInfoJson.optInt("is_mysterious_man") == 1) {
                this.hNk = 1;
            }
        }
        if (cmZ() || cna()) {
            xx(8);
            xy(8);
        } else if (cmU()) {
            xx(8);
            this.hNe.setText(a.h.ala_person_relieve_forbidden_forever);
        } else if (cmV()) {
            xx(0);
            this.hNd.setText(a.h.ala_person_relieve_forbidden_this);
            this.hNe.setText(a.h.ala_person_forbid_forever);
        } else {
            xx(0);
            this.hNd.setText(a.h.ala_person_forbid_this);
            this.hNe.setText(a.h.ala_person_forbid_forever);
        }
        if (cmT()) {
            this.hNf.setVisibility(8);
            this.hNh.setVisibility(8);
        } else if (cmX()) {
            this.hNf.setText(a.h.ala_person_fire_admin);
        } else if (cmW()) {
            this.hNf.setText(a.h.ala_person_appoint_admin);
        } else if (cmZ() && cmY()) {
            this.hNf.setText(a.h.ala_person_resign_admin);
        } else {
            this.hNf.setVisibility(8);
            this.hNh.setVisibility(8);
        }
    }

    public void a(b bVar) {
        this.hNj = bVar;
    }

    private boolean cmT() {
        return (this.hNi == null || this.hNi.user_info == null || this.hNi.user_info.is_block <= 0) ? false : true;
    }

    private boolean cmU() {
        return (this.hNi == null || this.hNi.user_info == null || this.hNi.user_info.is_block != 2) ? false : true;
    }

    private boolean cmV() {
        return (this.hNi == null || this.hNi.user_info == null || this.hNi.user_info.is_block != 1) ? false : true;
    }

    private boolean cmW() {
        return this.hNi != null && this.hNi.user_info != null && this.boZ && this.hNi.user_info.is_live_admin == 0;
    }

    private boolean cmX() {
        return this.hNi != null && this.hNi.user_info != null && this.boZ && this.hNi.user_info.is_live_admin == 1;
    }

    private boolean cmY() {
        return (this.hNi == null || this.hNi.login_user_info == null || this.boZ || this.hNi.login_user_info.is_live_admin != 1) ? false : true;
    }

    private boolean cmZ() {
        return (this.hNi == null || this.hNi.user_info == null || TextUtils.isEmpty(this.aGB) || !this.aGB.equals(this.hNi.user_info.user_id)) ? false : true;
    }

    private boolean cna() {
        return (this.hNi == null || this.hNi.user_info == null || this.hNi.user_info.is_live_admin != 1) ? false : true;
    }

    private void xx(int i) {
        this.hNd.setVisibility(i);
        this.hNg.setVisibility(i);
    }

    private void xy(int i) {
        this.hNe.setVisibility(i);
        this.hNh.setVisibility(i);
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
