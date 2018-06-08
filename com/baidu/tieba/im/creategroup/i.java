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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class i implements o {
    private int LS;
    private int egA;
    HeadImageView egW;
    ImageView egX;
    TextView egY;
    CreateGroupStepActivity egw;
    private int mIndex;
    View mView;
    private com.baidu.adp.widget.ImageView.a egZ = null;
    private a eha = null;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.egw = null;
        this.mView = null;
        this.egW = null;
        this.egX = null;
        this.egY = null;
        this.egw = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(d.i.create_group_step3_view, (ViewGroup) null);
        this.egX = (ImageView) this.mView.findViewById(d.g.step3_img_bg);
        this.egW = (HeadImageView) this.mView.findViewById(d.g.step3_img_scr);
        this.egY = (TextView) this.mView.findViewById(d.g.create_group3);
        this.mIndex = i;
        this.LS = i2;
        this.egA = i3;
    }

    public void aGM() {
        if (this.eha != null) {
            this.eha.cancel();
        }
        this.egZ = null;
        this.eha = new a();
        this.eha.execute(new Object[0]);
    }

    public ImageView aGN() {
        return this.egX;
    }

    public TextView aGO() {
        return this.egY;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aGx() {
        this.egX.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void aGy() {
        this.egw.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.egw.getLayoutMode().onModeChanged(this.mView);
        this.egW.refresh();
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
            return com.baidu.tbadk.core.util.l.ab(null, TbConfig.GROUP_HEAD_FILE);
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
                i.this.egW.setVisibility(0);
                i.this.egZ = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.egZ.a(i.this.egW);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.egw.getPageContext().getString(d.k.group_create_step_photo), Integer.valueOf(this.LS));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String aGA() {
        if (this.mIndex != this.egA) {
            return this.egw.getPageContext().getString(d.k.next_step);
        }
        return this.egw.getPageContext().getString(d.k.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aGB() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int aGr() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean aGC() {
        return true;
    }
}
