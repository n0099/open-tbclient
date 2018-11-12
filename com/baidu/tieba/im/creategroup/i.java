package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class i implements o {
    private int OH;
    CreateGroupStepActivity eEF;
    private int eEJ;
    HeadImageView eFf;
    ImageView eFg;
    TextView eFh;
    private com.baidu.adp.widget.ImageView.a eFi = null;
    private a eFj = null;
    private int mIndex;
    View mView;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.eEF = null;
        this.mView = null;
        this.eFf = null;
        this.eFg = null;
        this.eFh = null;
        this.eEF = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(e.h.create_group_step3_view, (ViewGroup) null);
        this.eFg = (ImageView) this.mView.findViewById(e.g.step3_img_bg);
        this.eFf = (HeadImageView) this.mView.findViewById(e.g.step3_img_scr);
        this.eFh = (TextView) this.mView.findViewById(e.g.create_group3);
        this.mIndex = i;
        this.OH = i2;
        this.eEJ = i3;
    }

    public void aNs() {
        if (this.eFj != null) {
            this.eFj.cancel();
        }
        this.eFi = null;
        this.eFj = new a();
        this.eFj.execute(new Object[0]);
    }

    public ImageView aNt() {
        return this.eFg;
    }

    public TextView aNu() {
        return this.eFh;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNd() {
        this.eFg.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aNe() {
        this.eEF.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eEF.getLayoutMode().onModeChanged(this.mView);
        this.eFf.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.l.au(null, TbConfig.GROUP_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (bitmap != null) {
                i.this.eFf.setVisibility(0);
                i.this.eFi = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.eFi.a(i.this.eFf);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.eEF.getPageContext().getString(e.j.group_create_step_photo), Integer.valueOf(this.OH));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aNg() {
        if (this.mIndex != this.eEJ) {
            return this.eEF.getPageContext().getString(e.j.next_step);
        }
        return this.eEF.getPageContext().getString(e.j.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNh() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aMX() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aNi() {
        return true;
    }
}
