package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends l {
    private EditText dyC;

    public c(Context context) {
        super(context, (String) null, 29);
        this.dxr = false;
        this.dxq = 3;
        this.dwz = new TopicDetaiInputContainer(context);
        this.dyC = ((TopicDetaiInputContainer) this.dwz).getInputView();
        ((TopicDetaiInputContainer) this.dwz).setHint(context.getString(R.string.say_your_point));
        this.dxs = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.dyC;
    }
}
